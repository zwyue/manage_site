package com.zr.gansu.service;

import com.zr.gansu.domain.UserCourse;

import java.util.Map;

/**
 * @ClassName UserCourseService
 * @Author Administrator
 * @Date 2019/2/15 14:04
 */
public interface UserCourseService {
    /**
     * 新增加入学习计划
     **/
    Map adduserCourse(Long courseId, Long userId);

    /**
     * 预览用户学习计划
     **/
    Map getAllStudyPlan(Long userId);

    /**
     *
     **/
    Integer selectPlanByCourseId(Long courseId,Long userId);

    /**
     * 退出学习计划
     **/
    Map endStudyPlan(Long courseId, Long userId);
}
