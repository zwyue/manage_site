package com.zr.gansu.dao;

import com.zr.gansu.domain.Vote;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface VoteMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Vote record);

    int insertSelective(Vote record);

    Vote selectByPrimaryKey(Long id);

    List<Vote> selectByCourseId(long courseId);

    int updateByPrimaryKeySelective(Vote record);

    int updateByPrimaryKey(Vote record);

    int queryAnswerIsClose(@Param("courseId") long courseId,@Param("endTime") Date endTime);


}