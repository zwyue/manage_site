package com.zr.gansu.dao;

import com.zr.gansu.domain.OldAgeActivity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 老年活动mapper类
 *
 * @author yuyi
 */
@Component
public interface OldAgeActivityMapper {

    int deleteByPrimaryKey(Long id);

    int insert(OldAgeActivity record);

    int insertSelective(OldAgeActivity record);

    OldAgeActivity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OldAgeActivity record);

    List<OldAgeActivity> findAllByType(@Param("type") Integer type);

    List<OldAgeActivity> findByTypeWithJoin(@Param("userId") Long userId, @Param("type") Integer type);
}