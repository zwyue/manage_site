package com.zr.gansu.dao;

import com.zr.gansu.domain.VoteOption;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VoteOptionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VoteOption record);

    int insertSelective(VoteOption record);

    VoteOption selectByPrimaryKey(Long id);

    List<VoteOption> selectOptionByVoteId(long voteId);

    int updateByPrimaryKeySelective(VoteOption record);

    int updateByPrimaryKey(VoteOption record);

    int isExitOption(@Param("voteId")Long voteId, @Param("optionName")String optionName);

}