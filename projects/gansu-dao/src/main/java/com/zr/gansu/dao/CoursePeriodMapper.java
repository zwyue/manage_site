package com.zr.gansu.dao;

import com.zr.gansu.domain.CoursePeriod;

import java.util.List;

public interface CoursePeriodMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CoursePeriod record);

    int insertSelective(CoursePeriod record);

    CoursePeriod selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CoursePeriod record);

    int updateByPrimaryKey(CoursePeriod record);

    List<CoursePeriod> selectByCourseId(Long courseId);
}