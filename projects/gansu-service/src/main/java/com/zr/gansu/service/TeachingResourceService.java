package com.zr.gansu.service;

import com.github.pagehelper.PageInfo;
import com.zr.gansu.domain.TeachingResource;
import com.zr.gansu.form.TeachingResourceForm;
import com.zr.gansu.vo.TeachingResourceInfoVo;

import java.util.List;

/**
 *@ClassName AdminEducationResources
 *@Desciption 教学资源service层
 *@Author wanglidong
 *@Date 2019/2/20 10:05
 */
public interface TeachingResourceService {


    /**
     * 添加教学资源
     * @param teachingResourceForm 教学资源
     * @return 影响的行数
     */
    Integer addTeachingResource(TeachingResourceForm teachingResourceForm);

    /**
     * 查询所有的教学资源
     * @param pageNum   pageSize
     * @return PageInfo
     */
    PageInfo  queryAll(Integer pageNum,Integer pageSize);
    /**
     * 根据资源类型查询教学资源
     * @param pageNum  pageSize type
     * @return PageInfo
     */
    PageInfo queryResourceByType(Integer pageNum,Integer pageSize,String type);

    /**
     *根据资源id查询教学资源内容
     * @param id 资源id
     * @return PageInfo
     */
    TeachingResourceInfoVo queryResourceInfoById(Long id);

    /**
     * 修改教学资源
     */
    Integer modifyTeachingResource(TeachingResourceForm teachingResourceForm);

    /**
     *删除教学资源
     */
    Integer delTeachingResource(Long id);

    /**
     *更新浏览量
     */
    boolean updateTeachingResourceViewCounts(Long id);
    /**
     *更新点赞量
     */
    Long updateTeachingResourceLikeCounts(Long id);

    /**
     * 查询4个推荐教学资源
     */
    List<TeachingResource> teachingResource(String type);
}
