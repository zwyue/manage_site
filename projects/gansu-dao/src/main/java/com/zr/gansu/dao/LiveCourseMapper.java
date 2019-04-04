package com.zr.gansu.dao;

import com.zr.gansu.domain.LiveCourse;

public interface LiveCourseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LiveCourse record);

    int insertSelective(LiveCourse record);

    LiveCourse selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LiveCourse record);

    int updateByPrimaryKey(LiveCourse record);
}