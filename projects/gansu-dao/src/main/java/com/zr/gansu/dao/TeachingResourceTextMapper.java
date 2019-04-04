package com.zr.gansu.dao;

import com.zr.gansu.domain.TeachingResourceText;

public interface TeachingResourceTextMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TeachingResourceText record);

    int insertSelective(TeachingResourceText record);

    TeachingResourceText selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TeachingResourceText record);

    int updateByPrimaryKeyWithBLOBs(TeachingResourceText record);
}