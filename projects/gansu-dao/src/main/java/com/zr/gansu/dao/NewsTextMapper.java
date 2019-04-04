package com.zr.gansu.dao;

import com.zr.gansu.domain.NewsText;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface NewsTextMapper {
    int insertSelective(NewsText record);

    NewsText selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NewsText record);
}