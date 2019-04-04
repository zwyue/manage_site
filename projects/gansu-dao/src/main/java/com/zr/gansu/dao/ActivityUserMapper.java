package com.zr.gansu.dao;

import com.zr.gansu.domain.ActivityUser;
import org.springframework.stereotype.Component;

@Component
public interface ActivityUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ActivityUser record);

    int insertSelective(ActivityUser record);

    ActivityUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ActivityUser record);

    int updateByPrimaryKey(ActivityUser record);

    ActivityUser selectActivityUser(Long activityId);
}