package com.zr.gansu.dao;

import com.zr.gansu.domain.OldAgeActivityUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface OldAgeActivityUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(OldAgeActivityUser record);

    int insertSelective(OldAgeActivityUser record);

    OldAgeActivityUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OldAgeActivityUser record);

    OldAgeActivityUser selectByUserIdAndActivityId(@Param("userId") Long userId, @Param("activityId") Long activityId);
}