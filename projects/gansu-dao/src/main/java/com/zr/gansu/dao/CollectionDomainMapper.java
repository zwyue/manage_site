package com.zr.gansu.dao;

import com.zr.gansu.domain.CollectionDomain;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface CollectionDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CollectionDomain record);

    int insertSelective(CollectionDomain record);

    CollectionDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CollectionDomain record);

    int updateByPrimaryKey(CollectionDomain record);

    /**
     * 根据用户ID和课程ID查询
     *
     * @author yuyi
     *
     * @param userId 用户ID
     *
     * @param courseId 课程ID
     *
     * @return CollectionDomain
     */
    CollectionDomain findByUserIdAndCourseId(@Param("userId") Long userId, @Param("courseId") Long courseId);

    /**
     * 查找用户的所有收藏
     **/
    List<CollectionDomain> selectByUserId(Long userId);

}