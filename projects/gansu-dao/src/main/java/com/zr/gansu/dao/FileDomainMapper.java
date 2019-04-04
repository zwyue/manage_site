package com.zr.gansu.dao;

import com.zr.gansu.domain.FileDomain;

public interface FileDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FileDomain record);

    int insertSelective(FileDomain record);

    FileDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FileDomain record);

    int updateByPrimaryKey(FileDomain record);
}