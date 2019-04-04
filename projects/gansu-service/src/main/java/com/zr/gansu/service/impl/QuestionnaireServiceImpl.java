package com.zr.gansu.service.impl;

import com.zr.gansu.common.log.Log;
import com.zr.gansu.dao.OptionMapper;
import com.zr.gansu.dao.QuestionMapper;
import com.zr.gansu.dao.QuestionnaireMapper;
import com.zr.gansu.domain.Questionnaire;
import com.zr.gansu.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: yufei
 * @Description:问卷调查接口实现类
 * @Date: Create in 16:38 2018/12/28
 */
@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

    private final
    QuestionnaireMapper questionnaireMapper;

    private final
    QuestionMapper questionMapper;

    private final
    OptionMapper optionMapper;

    @Autowired
    public QuestionnaireServiceImpl(QuestionnaireMapper questionnaireMapper, QuestionMapper questionMapper, OptionMapper optionMapper) {
        this.questionnaireMapper = questionnaireMapper;
        this.questionMapper = questionMapper;
        this.optionMapper = optionMapper;
    }


    @Override
    @Log
    @Transactional(rollbackFor = Exception.class)
    public int insert(Questionnaire record) {
        return questionnaireMapper.insert(record);
    }

    @Override
    @Log
    public Questionnaire selectByPrimaryKey(Long id) {
        return questionnaireMapper.selectByPrimaryKey(id);
    }

    @Override
    @Log
    public Questionnaire selectQuestionnaire(Long id) {
        return questionnaireMapper.selectQuestionnaire(id);
    }

    @Override
    @Log
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(Questionnaire record) {
        return questionnaireMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Log
    @Transactional(rollbackFor = Exception.class)
    public int updateIsDeleted(Long id) {
        return questionnaireMapper.updateIsDeleted(id);
    }

    @Override
    @Log
    @Transactional(rollbackFor = Exception.class)
    public int updateStatus(Long id) {
        return questionnaireMapper.updateStatus(id);
    }

    @Override
    @Log
    @Transactional(rollbackFor = Exception.class)
    public int deleteQuestionnaire(Long questionnaireId){
        //删除调查问卷表信息
        if(questionnaireMapper.deleteByPrimaryKey(questionnaireId)>0){
            //删除调查问卷问题选项表信息
            if(optionMapper.deleteByPrimaryKey(questionnaireId)>0){
                //删除调查问卷问题表信息
                if(questionMapper.deleteByPrimaryKey(questionnaireId)>0){
                    return 1;
                }else{
                    return 0;
                }
            }else{
                return 0;
            }
        }
        return 0;
    }
}
