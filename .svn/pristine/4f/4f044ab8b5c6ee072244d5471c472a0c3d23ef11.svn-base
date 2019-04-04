package com.zr.gansu.dao;

import com.zr.gansu.domain.VoteAnswer;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface VoteAnswerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VoteAnswer record);

    int insertSelective(VoteAnswer record);

    VoteAnswer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VoteAnswer record);

    int updateByPrimaryKey(VoteAnswer record);

    int queryAnswerIsExit(@Param("userId") long userId, @Param("voteId")long voteId);

    Map countAnswerNumberByVoteId(@Param("voteId")long voteId,@Param("optionName") String optionName);
}