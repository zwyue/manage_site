package com.zr.gansu.service.impl;

import com.zr.gansu.common.log.Log;
import com.zr.gansu.dao.QuestionMapper;
import com.zr.gansu.domain.Question;
import com.zr.gansu.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: yufei
 * @Description:调查问卷问题接口实现类
 * @Date: Create in 18:00 2018/12/28
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    private final
    QuestionMapper questionMapper;

    @Autowired
    public QuestionServiceImpl(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }


    @Override
    @Log
    public int insert(Question record) {
        return questionMapper.insert(record);
    }

    @Override
    @Log
    public Question selectQuAndOptions(Long id) {
        return questionMapper.selectQuAndOptions(id);
    }

    @Override
    @Log
    public int deleteByPrimaryKey(Long questionnaireId) {
        return questionMapper.deleteByPrimaryKey(questionnaireId);
    }

    @Override
    @Log
    public int updateByPrimaryKeySelective(Question record) {
        return questionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Log
    public int updateIsDeleted(Long id) {
        return questionMapper.updateIsDeleted(id);
    }

}
