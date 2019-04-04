package com.zr.gansu.dao;

import com.zr.gansu.domain.CollectionTagRealtionship;

import java.util.List;

public interface CollectionTagRealtionshipMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CollectionTagRealtionship record);

    int insertSelective(CollectionTagRealtionship record);

    CollectionTagRealtionship selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CollectionTagRealtionship record);

    int updateByPrimaryKey(CollectionTagRealtionship record);
    /**
     * 通过用户ID和收藏ID查找
     **/
    List<CollectionTagRealtionship> selectByUserIdAndCollectionId(Long userId, Long collectionId);
}