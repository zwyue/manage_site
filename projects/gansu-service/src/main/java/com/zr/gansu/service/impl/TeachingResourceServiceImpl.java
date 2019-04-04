package com.zr.gansu.service.impl;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zr.gansu.common.constants.Constants;
import com.zr.gansu.dao.TeachingResourceMapper;
import com.zr.gansu.dao.TeachingResourceTextMapper;
import com.zr.gansu.domain.TeachingResource;
import com.zr.gansu.domain.TeachingResourceText;
import com.zr.gansu.form.TeachingResourceForm;
import com.zr.gansu.service.TeachingResourceService;
import com.zr.gansu.vo.TeachingResourceInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 *@ClassName TeachingResourceServiceImpl
 *@Desciption 教学资源资源实现类
 *@Author wanglidong
 *@Date 2019/2/20 10:12
 */
@Service
public class TeachingResourceServiceImpl implements TeachingResourceService {

    @Resource
    private TeachingResourceMapper teachingResourceMapper;
    @Resource
    private TeachingResourceTextMapper teachingResourceTextMapper;

    @Override
    public Integer addTeachingResource(TeachingResourceForm teachingResourceForm) {
            //先添加资源内容
        if(ObjectUtil.isNotNull(teachingResourceForm.getContentText())){
            TeachingResourceText teachingResourceText=new TeachingResourceText();
            teachingResourceText.setContent(teachingResourceForm.getContentText());
            Integer statusText= teachingResourceTextMapper.insertSelective(teachingResourceText);
            if(!statusText.equals(Constants.EXECUTE_FAIL)){
                //再添加资源先关信息
                TeachingResource teachingResource=new TeachingResource();
                //对象映射
                BeanUtils.copyProperties(teachingResourceForm,teachingResource);
                //补充相关信息
                Date timeNow=new Date(System.currentTimeMillis());
                teachingResource.setContent(teachingResourceText.getId());
                teachingResource.setGmtCreate(timeNow);
                teachingResource.setGmtModified(timeNow);
               //保存
                Integer status  = teachingResourceMapper.insertSelective(teachingResource);
                if(!status.equals(Constants.EXECUTE_FAIL)){
                    return 1;
                }
            }
        }

        return 0;
    }

    @Override
    public PageInfo queryAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize,"gmt_create desc");
        List<TeachingResource> teachingResources = teachingResourceMapper.queryResource();
        PageInfo<TeachingResource> pageInfo = new  PageInfo<>(teachingResources);
        return pageInfo;
    }

    @Override
    public PageInfo queryResourceByType(Integer pageNum,Integer pageSize,String type) {
        PageHelper.startPage(pageNum,pageSize,"gmt_create desc");
        List<TeachingResource> teachingResource = teachingResourceMapper.queryResourceByType(type);
        PageInfo<TeachingResource> pageInfo = new PageInfo<>(teachingResource);
        return pageInfo;
    }

    @Override
    public TeachingResourceInfoVo queryResourceInfoById(Long id) {
        return teachingResourceMapper.queryResourceInfoById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer modifyTeachingResource(TeachingResourceForm teachingResourceForm) {
        TeachingResource queryTeachingResource = teachingResourceMapper.selectByPrimaryKey(teachingResourceForm.getId());
            if(ObjectUtil.isNotNull(queryTeachingResource)){
                //先修改教学资源相关信息
                TeachingResource teachingResource=new TeachingResource();
                //对象映射
                BeanUtils.copyProperties(teachingResourceForm,teachingResource);
                //补充相关信息
                teachingResource.setGmtModified(new Date(System.currentTimeMillis()));
                Integer status = teachingResourceMapper.updateByPrimaryKeySelective(teachingResource);
                if(!status.equals(Constants.EXECUTE_FAIL)){
                    TeachingResourceText teachingResourceText=new TeachingResourceText();
                    teachingResourceText.setId(queryTeachingResource.getContent());
                    teachingResourceText.setContent(teachingResourceForm.getContentText());
                  return teachingResourceTextMapper.updateByPrimaryKeySelective(teachingResourceText);
                }else{
                    return 0;
                }
            }
            return 0;
    }

    @Override
    public Integer delTeachingResource(Long id) {
        TeachingResource teachingResource = teachingResourceMapper.selectByPrimaryKey(id);
        if(ObjectUtil.isNotNull(teachingResource)){
            if(teachingResource.getIsDeleted().equals(Constants.IS_DELETED_NO)){
                //更新删除状态
                teachingResource.setIsDeleted(Constants.IS_DELETED_YES);
                return teachingResourceMapper.updateByPrimaryKeySelective(teachingResource);
            }else{
                return 2;
            }
        }
        return 0;
    }

    @Override
    public boolean updateTeachingResourceViewCounts(Long id) {
        try{
            TeachingResource teachingResource = teachingResourceMapper.selectByPrimaryKey(id);
            teachingResource.setViewCount(teachingResource.getViewCount()+1);
            teachingResourceMapper.updateByPrimaryKeySelective(teachingResource);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long updateTeachingResourceLikeCounts(Long id) {
        TeachingResource teachingResource = teachingResourceMapper.selectByPrimaryKey(id);
        if(ObjectUtil.isNotNull(teachingResource)){
            Long likeCount = teachingResource.getLikeCount();
            teachingResource.setLikeCount(likeCount+1);
            Integer  status = teachingResourceMapper.updateByPrimaryKeySelective(teachingResource);
            if(!status.equals(Constants.EXECUTE_FAIL)){
                return likeCount+1;
            }else{
                return 0L;
            }
        }
        //更新失败
        return 0L;
    }

    @Override
    public List<TeachingResource> teachingResource(String type) {
        //查询4个推荐的教学资源：根据设置的推荐和时间查询
       return teachingResourceMapper.recommendTeachingResource(type);
    }
}
