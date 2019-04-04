package com.zr.gansu.dao;

import com.zr.gansu.domain.Course;
import com.zr.gansu.vo.CourseVo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @description  课程Mapper
 * @author    Wg
 * @date     2018/12/20 15:35
 */
@Component
public interface CourseMapper {

    /**
     *  根据主键删除课程
     *
     * @author    Wg
     * @param id 主键
     * @date     2018/12/20 16:04
     * @return 是否删除成功
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 添加课程信息全部
     *
     * @author wanggang
     * @date 16:17 2018/12/20
     * @param record 课程
     * @return 是否插入成功
     **/
    int insert(Course record);

    /**
     * 添加传入的课程信息
     *
     * @author wanggang
     * @date 16:19 2018/12/20
     * @param record 课程
     * @return 是否插入成功
     **/
    int insertSelective(Course record);

    /**
     *  根据主键查询课程信息
     *
     * @author wanggang
     * @date 8:59 2018/12/21
     * @param id 主键
     * @return 课程信息
     **/
    Course selectByPrimaryKey(Long id);

    /**
     *  根据主键更新课程的信息
     *
     * @author wanggang
     * @date 9:38 2018/12/21
     * @param record 要更新课程的信息
     * @return 是否更新成功
     **/
    int updateByPrimaryKeySelective(Course record);

    /**
     * 根据主键更新课程全部的信息
     *
     * @author wanggang
     * @date 9:41 2018/12/21
     * @param record 需要更新的信息
     * @return 是否更新成功
     **/
    int updateByPrimaryKey(Course record);

    /**
     * 根据条件查询课程列表信息
     *
     * @author wanggang
     * @date 9:48 2018/12/21
     * @param map 查询条件
     * @return 课程列表信息
     **/
    List<Course> queryCourseList(Map<String,Object> map);

    /**
     * 统计对应标签ID的课程数量
     *
     * @author yuyi
     *
     * @param tagId 标签ID
     *
     * @return Integer
     */
    Integer countByTagId(Long tagId);

    List<CourseVo> findByTagId(Long tagId);

    /**
     * 查找所有课程
     **/
    List<Course> selectByAuthId(String teacherId);
}