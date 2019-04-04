package com.zr.gansu.service;

import com.zr.gansu.domain.Answer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: yufei
 * @Description:调查问卷用户回答service接口
 * @Date: Create in 9:27 2019/2/14
 */
public interface AnswerService {

    int insert(Answer record);

    List<Answer> selectByPrimaryKey(Long questionId);

    Map countPercent(Long questionId);

    Long checkQuestionId(Long questionId);

}
