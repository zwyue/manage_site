package com.zr.gansu.dao;

import com.zr.gansu.domain.Answer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kaizhang
 */
@Repository
public interface AnswerMapper {
    int insert(Answer record);

    List<Answer> selectByPrimaryKey(Long questionId);

    Long checkQuestionId(Long questionId);

    /**
     * 统计选项A所占问题答案的百分比
     * @param questionId 问题id
     * @return 百分比
     */
    float countA(Long questionId);

    /**
     * 统计选项B所占问题答案的百分比
     * @param questionId 问题id
     * @return 百分比
     */
    float countB(Long questionId);

    /**
     * 统计选项C所占问题答案的百分比
     * @param questionId 问题id
     * @return 百分比
     */
    float countC(Long questionId);

    /**
     * 统计选项D所占问题答案的百分比
     * @param questionId 问题id
     * @return 百分比
     */
    float countD(Long questionId);

}