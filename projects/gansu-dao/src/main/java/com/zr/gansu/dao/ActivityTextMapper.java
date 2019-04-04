package com.zr.gansu.dao;

import com.zr.gansu.domain.ActivityText;
import org.springframework.stereotype.Component;

@Component
public interface ActivityTextMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ActivityText record);

    int insertSelective(ActivityText record);

    ActivityText selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ActivityText record);

    int updateByPrimaryKeyWithBLOBs(ActivityText record);
}