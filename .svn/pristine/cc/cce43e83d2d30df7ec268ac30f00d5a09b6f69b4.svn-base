package com.zr.gansu.service.impl;

import com.zr.gansu.common.log.Log;
import com.zr.gansu.dao.AnswerMapper;
import com.zr.gansu.domain.Answer;
import com.zr.gansu.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yufei
 * @Description:调查问卷用户回复接口实现类
 * @Date: Create in 9:28 2019/2/14
 */
@Service
public class AnswerServiceImpl implements AnswerService {

    private final
    AnswerMapper answerMapper;

    @Autowired
    public AnswerServiceImpl(AnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }


    @Override
    @Log
    public int insert(Answer record) {
        return answerMapper.insert(record);
    }

    @Override
    @Log
    public List<Answer> selectByPrimaryKey(Long questionId) {
        return answerMapper.selectByPrimaryKey(questionId);
    }


    @Override
    @Log
    public Map countPercent(Long questionId) {
        Map<String,Float> map = new HashMap<>();
       float percentA = answerMapper.countA(questionId);
       float percentB = answerMapper.countB(questionId);
       float percentC = answerMapper.countC(questionId);
       float percentD = answerMapper.countD(questionId);
       map.put("percentA",percentA);
       map.put("percentB",percentB);
       map.put("percentC",percentC);
       map.put("percentD",percentD);
        return map;
    }

    @Override
    @Log
    public Long checkQuestionId(Long questionId) {
        return answerMapper.checkQuestionId(questionId);
    }


}
