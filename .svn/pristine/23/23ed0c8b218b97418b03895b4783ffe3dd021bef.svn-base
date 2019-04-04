package com.zr.gansu.service;

import com.zr.gansu.domain.Questionnaire;

/**
 * @Author: yufei
 * @Description:调查问卷serivce接口
 * @Date: Create in 16:35 2018/12/28
 */

public interface QuestionnaireService {

    /**
     * 删除调查问卷 删除未保存状态下的问卷信息
     * @param questionnaireId 问卷questionnaireId
     * @return 影响的行数
     */
    int deleteQuestionnaire(Long questionnaireId);

    /**
     * 新增调查问卷
     * @param record 问卷信息
     * @return 影响的行数
     */
    int insert(Questionnaire record);

    /**
     * 查询调查问卷基本信息
     * @param id 问卷id
     * @return 问卷基本信息
     */
    Questionnaire selectByPrimaryKey(Long id);

    /**
     * 查询调查问卷详细信息 包含整个问卷信息
     * @param id 问卷id
     * @return 问卷详细信息
     */
    Questionnaire selectQuestionnaire(Long id);

    /**
     * 修改问卷基本信息
     * @param record 问卷基本信息
     * @return 影响的行数
     */
    int updateByPrimaryKeySelective(Questionnaire record);

    /**
     * 删除调查问卷 逻辑删除
     * @param id 问卷id
     * @return 影响的行数
     */
    int updateIsDeleted(Long id);

    /**
     * 修改问卷发布状态
     * @param id 问卷id
     * @return 影响的行数
     */
    int updateStatus(Long id);
}
