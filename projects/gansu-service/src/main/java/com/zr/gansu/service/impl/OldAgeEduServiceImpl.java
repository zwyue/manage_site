package com.zr.gansu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zr.gansu.common.constants.Constants;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.dao.OldAgeActivityMapper;
import com.zr.gansu.dao.OldAgeActivityTextMapper;
import com.zr.gansu.dao.OldAgeActivityUserMapper;
import com.zr.gansu.domain.OldAgeActivity;
import com.zr.gansu.domain.OldAgeActivityText;
import com.zr.gansu.domain.OldAgeActivityUser;
import com.zr.gansu.form.OldAgeActivityForm;
import com.zr.gansu.service.OldAgeEduService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 老年活动 service impl
 *
 * @author yuyi
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OldAgeEduServiceImpl implements OldAgeEduService {

    @Autowired
    private OldAgeActivityMapper oldAgeActivityMapper;

    @Autowired
    private OldAgeActivityTextMapper oldAgeActivityTextMapper;

    @Autowired
    private OldAgeActivityUserMapper oldAgeActivityUserMapper;

    @Override
    public void addOldAgeActivity(OldAgeActivityForm oldAgeActivityForm) {
        //todo 用户ID
        Long userId = 0L;
        //先添加活动内容
        String content = oldAgeActivityForm.getContentText().trim();
        OldAgeActivityText oldAgeActivityText = insertContent(content);
        //添加活动基本信息
        OldAgeActivity newData = new OldAgeActivity();
        BeanUtils.copyProperties(oldAgeActivityForm,newData);
        //参数补齐
        newData.setContentId(oldAgeActivityText.getId());
        newData.setCreatorId(userId);
        newData.setGmtCreate(new Date());
        newData.setGmtModified(new Date());
        newData.setViewCount(0);
        oldAgeActivityMapper.insertSelective(newData);
    }

    @Override
    public void modifyOldAgeActivity(OldAgeActivityForm oldAgeActivityForm) {
        //先更新活动内容
        Long contentId = oldAgeActivityForm.getContentId();
        String content = oldAgeActivityForm.getContentText();
        if(content != null && !content.trim().equalsIgnoreCase("")) {
            updateContent(contentId,content);
        }
        //更新基本信息
        OldAgeActivity modifyData = new OldAgeActivity();
        BeanUtils.copyProperties(oldAgeActivityForm,modifyData);
        //参数补齐
        modifyData.setGmtModified(new Date());
        oldAgeActivityMapper.updateByPrimaryKeySelective(modifyData);
    }


    @Override
    public void deleteOldAgeActivity(Long id) {
        OldAgeActivity modifyData = new OldAgeActivity();
        modifyData.setId(id);
        modifyData.setIsDeleted(Constants.IS_DELETED_YES);
        oldAgeActivityMapper.updateByPrimaryKeySelective(modifyData);
    }

    @Override
    public PageInfo<OldAgeActivity> findByPagination(Integer type,Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<OldAgeActivity> list = oldAgeActivityMapper.findAllByType(type);
        PageInfo<OldAgeActivity> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public OldAgeActivity findByActivityId(Long id) {
        return oldAgeActivityMapper.selectByPrimaryKey(id);
    }

    @Override
    public OldAgeActivityText findByContentId(Long id) {
        return oldAgeActivityTextMapper.selectByPrimaryKey(id);
    }

    @Override
    public Map signUp(Long activityId) {
        //todo userId
        Long userId = 0L;
        //查询用户是否已经报名
        OldAgeActivityUser oldAgeActivityUser = oldAgeActivityUserMapper.selectByUserIdAndActivityId(userId,activityId);
        if(oldAgeActivityUser != null) {
            return ResultUtils.error(false,"请勿重复报名");
        } else {
            OldAgeActivityUser newData = new OldAgeActivityUser();
            newData.setUserId(userId);
            newData.setActivityId(activityId);
            oldAgeActivityUserMapper.insertSelective(newData);
            //更新总人数
            OldAgeActivity oldAgeActivity = oldAgeActivityMapper.selectByPrimaryKey(activityId);
            oldAgeActivity.setTotalPeople(oldAgeActivity.getTotalPeople() + 1);
            oldAgeActivityMapper.updateByPrimaryKeySelective(oldAgeActivity);
            return ResultUtils.success(true,"报名成功");
        }
    }

    @Override
    public Map signOut(Long activityId) {
        //todo userId
        Long userId = 0L;
        //查询用户是否已经报名
        OldAgeActivityUser oldAgeActivityUser = oldAgeActivityUserMapper.selectByUserIdAndActivityId(userId,activityId);
        if(oldAgeActivityUser == null) {
            return ResultUtils.error(false,"用户尚未参加");
        } else {
            oldAgeActivityUserMapper.deleteByPrimaryKey(oldAgeActivityUser.getId());
            //更新总人数
            OldAgeActivity oldAgeActivity = oldAgeActivityMapper.selectByPrimaryKey(activityId);
            oldAgeActivity.setTotalPeople(oldAgeActivity.getTotalPeople() - 1);
            oldAgeActivityMapper.updateByPrimaryKeySelective(oldAgeActivity);
            return ResultUtils.success(true,"取消成功");
        }
    }

    @Override
    public Map isJoin(Long activityId) {
        //todo userId
        Long userId = 0L;
        OldAgeActivityUser oldAgeActivityUser = oldAgeActivityUserMapper.selectByUserIdAndActivityId(userId,activityId);
        if(oldAgeActivityUser == null) {
            return ResultUtils.success(false,"用户尚未参加");
        } else {
            return ResultUtils.success(true,"用户已参加");
        }
    }

    @Override
    public PageInfo findByPaginationWithJoin(Integer type, Integer page, Integer size) {
        //todo userId
        Long userId = 0L;
        PageHelper.startPage(page,size);
        List<OldAgeActivity> list = oldAgeActivityMapper.findByTypeWithJoin(userId,type);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;

    }

    @Override
    public Map checkIn(Long activityId) {
        //todo userId
        Long userId = 0L;
        //判断用户是否参加
        OldAgeActivityUser oldAgeActivityUser = oldAgeActivityUserMapper.selectByUserIdAndActivityId(userId,activityId);
        if(oldAgeActivityUser == null) {
            return ResultUtils.error(false,"用户尚未参加");
        } else {
            if(Constants.OldAgeEdu.CHECK_IN_YES.equals(oldAgeActivityUser.getCheckIn())) {
                return ResultUtils.error(false,"请勿重复签到");
            } else {
                oldAgeActivityUser.setCheckIn(Constants.OldAgeEdu.CHECK_IN_YES);
                oldAgeActivityUser.setCheckInTime(new Date());
                oldAgeActivityUserMapper.updateByPrimaryKeySelective(oldAgeActivityUser);
                return ResultUtils.success(true,"签到成功");
            }
        }
    }

    @Override
    public Map signOff(Long activityId) {
        //todo userId
        Long userId = 0L;
        //判断用户是否参加
        OldAgeActivityUser oldAgeActivityUser = oldAgeActivityUserMapper.selectByUserIdAndActivityId(userId,activityId);
        if(oldAgeActivityUser == null) {
            return ResultUtils.error(false,"用户尚未参加");
        } else {
            if(Constants.OldAgeEdu.SIGN_OFF_YES.equals(oldAgeActivityUser.getSignOff())) {
                return ResultUtils.error(false,"请勿重复签退");
            } else {
                oldAgeActivityUser.setSignOff(Constants.OldAgeEdu.SIGN_OFF_YES);
                oldAgeActivityUser.setSignOffTime(new Date());
                oldAgeActivityUserMapper.updateByPrimaryKeySelective(oldAgeActivityUser);
                return ResultUtils.success(true,"签退成功");
            }
        }
    }

    /**
     * 添加活动内容
     *
     * @author yuyi
     *
     * @param content
     *
     * @return
     */
    private OldAgeActivityText insertContent(String content){
        OldAgeActivityText newContentData = new OldAgeActivityText();
        newContentData.setContentText(content);
        oldAgeActivityTextMapper.insert(newContentData);
        return newContentData;
    }

    /**
     * 更新活动内容
     *
     * @author yuyi
     *
     * @param contentId
     *
     * @param content
     *
     * @return
     */
    private void updateContent(Long contentId,String content){
        OldAgeActivityText contentData = new OldAgeActivityText();
        contentData.setId(contentId);
        contentData.setContentText(content);
        oldAgeActivityTextMapper.updateByPrimaryKeyWithBLOBs(contentData);
    }
}
