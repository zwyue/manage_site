package com.zr.gansu.dao;

import com.zr.gansu.domain.TeachingResource;
import com.zr.gansu.vo.TeachingResourceInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeachingResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TeachingResource record);

    int insertSelective(TeachingResource record);

    TeachingResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TeachingResource record);

    int updateByPrimaryKey(TeachingResource record);

    List<TeachingResource> queryResource();

    List<TeachingResource> queryResourceByType(String type);

    TeachingResourceInfoVo queryResourceInfoById(Long id);

    List<TeachingResource> recommendTeachingResource(@Param("type") String type);
}