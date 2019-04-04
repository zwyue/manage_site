package com.zr.gansu.dao;

import com.zr.gansu.domain.UserCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserCourseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserCourse record);

    int insertSelective(UserCourse record);

    UserCourse selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserCourse record);

    int updateByPrimaryKey(UserCourse record);

    /**
     * 根据课程id查询该用户是否参与该课程的学习
     * @param userId
     * @param courseId
     * @return
     */
    int queryByCourseId(@Param("userId")long userId, @Param("courseId")long courseId);

    /**
     * 查找该用户正在学习的课程
     **/
    List<UserCourse> selectByUserId(Long userId);

    UserCourse selectByCourseIdAndUserId(Long courseId, Long userId);
}