package com.zr.gansu.service;

import com.github.pagehelper.PageInfo;
import com.zr.gansu.domain.Course;
import com.zr.gansu.form.CourseForm;
import com.zr.gansu.vo.CourseVo;

import java.util.List;
import java.util.Map;

/**
 * @description  课程接口
 * @author    Wg
 * @date     2018/12/20 11:05
 */
public interface CourseService {

    /**
     * 获取课程列表
     *
     * @author    Wg
     * @date     2018/12/20 11:06
     * @param   course 课程
     * @return 返回课程相关的信息
     */
    List<Course> getCourseList(Course course);

    /**
     * 根据课程的标签ID获取相关课程
     *
     * @author yuyi
     *
     * @param tagId
     *
     * @return
     */
    List<CourseVo> getRecommendCourses(Long tagId);

    /**
     * 该课程是否存在 （不包括删除的）
     * @author   wanglidong
     * @date     2018/12/20 11:06
     * @param   courseId 课程id()
     * @return 返回课程相关的信息
     */
    boolean isExist(long courseId);

	/**
     * 通过课程ID查找对应课程
     **/
    Course findById(Long lessonId);

    /**
     * 更新课程表
     **/
    void updateCourse(Course course);

    /**
     * 新建课程
     **/
    Map createCourse(CourseForm courseForm);

    /**
     * 查询所有课程
     **/
    Map selectAllCourse(String teacherId, Integer page, Integer size);

    /**
     * 审核课程
     **/
    Map auditCourse(Course course,Integer auditStatus,String auditOpinion);

    /**
     * 删除课程
     **/
    Map deleteById(Long courseId);
}
