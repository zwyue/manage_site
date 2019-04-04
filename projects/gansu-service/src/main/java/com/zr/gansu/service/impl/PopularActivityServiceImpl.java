package com.zr.gansu.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zr.gansu.common.constants.Constants;
import com.zr.gansu.dao.PopularActivityMapper;
import com.zr.gansu.dao.PopularActivityTextMapper;
import com.zr.gansu.domain.PopularActivity;
import com.zr.gansu.domain.PopularActivityText;
import com.zr.gansu.service.PopularActivityService;
import com.zr.gansu.vo.PopularActivityVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/***
 * @Author wanglidong
 * @Description 热门活动接口
 * @Date 2019/2/12 14:57
 * @Param
 * @return
**/
@Service
public class PopularActivityServiceImpl implements PopularActivityService {

    @Resource
    private PopularActivityMapper popularActivityMapper;

    @Resource
    private PopularActivityTextMapper popularActivityTextMapper;
    /**
     * 添加热门活动内容
     * @param popularActivityText
     * @return
     */
    @Override
    public int addActivityText(PopularActivityText popularActivityText) {
        return popularActivityTextMapper.insertSelective(popularActivityText);
    }

    /**
     * 添加热门活动信息
     * @param popularActivity
     * @return
     */
    @Override
    public int addActivity(PopularActivity popularActivity) {
        //补充相关信息
       Date timeNow=new Date(System.currentTimeMillis());
       popularActivity.setGmtCreate(timeNow);
       popularActivity.setGmtModified(timeNow);
       return popularActivityMapper.insertSelective(popularActivity);
    }

    /**
     * 查询热门活动信息列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo queryActivity(Integer pageNum, Integer pageSize,Long siteId) {
        PageHelper.startPage(pageNum,pageSize,"gmt_create desc");
        if(ObjectUtil.isNotNull(siteId)){
            List<PopularActivity> popularActivities = popularActivityMapper.queryActivity(siteId);
            PageInfo<PopularActivity> pageInfo=new PageInfo<>(popularActivities);
            return pageInfo;
        }else{
            return new PageInfo(null);
        }

    }

    @Override
    public PopularActivityVo queryActivityVo(long activityId) {
        return  popularActivityMapper.queryActivityById(activityId);
    }

    @Override
    public int modifyActivityInfo(PopularActivity popularActivity, String contentText) {
        //查询这条记录
        PopularActivity queryActivity = popularActivityMapper.selectByPrimaryKey(popularActivity.getId());
        if(ObjectUtil.isNotNull(queryActivity)){
            //更新活动相关信息
            popularActivity.setGmtModified(new Date(System.currentTimeMillis()));
            Integer modifySattus = popularActivityMapper.updateByPrimaryKeySelective(popularActivity);
            if(!modifySattus.equals(Constants.EXECUTE_FAIL)){
                //更新内容信息
                PopularActivityText popularActivityText=new PopularActivityText();
                popularActivityText.setId(queryActivity.getContentId());
                popularActivityText.setContentText(contentText);
                return  popularActivityTextMapper.updateByPrimaryKeySelective(popularActivityText);
            }else{
                return 0;
            }
        }
        return 0;
    }

    @Override
    public int delActivityById(long activityId) {
       //查询记录
        PopularActivity popularActivity = popularActivityMapper.selectByPrimaryKey(activityId);
        if(popularActivity!=null){
            if(popularActivity.getIsDeleted().equals(Constants.IS_DELETED_YES)){
                //该记录已被删除！
                return 2;
            }else{
                //更改状态
                popularActivity.setIsDeleted(Constants.IS_DELETED_YES);
                return popularActivityMapper.updateByPrimaryKeySelective(popularActivity);
            }
        }
        return 0;
    }

    /**
     * 更新查看活动的浏览量
     * @param activityId
     * @return
     */
    @Override
    public boolean updateActivityCounts(long activityId) {
        try{
            PopularActivity popularActivity = popularActivityMapper.selectByPrimaryKey(activityId);
            popularActivity.setCounts(popularActivity.getCounts()+1);
            //更新
            popularActivityMapper.updateByPrimaryKeySelective(popularActivity);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
