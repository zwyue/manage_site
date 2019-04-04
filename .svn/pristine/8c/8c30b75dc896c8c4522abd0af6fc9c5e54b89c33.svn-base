package com.zr.gansu.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;

/**
 * @Author: yufei
 * @Description:
 * @Date: Create in 10:09 2019/2/14
 */
@ApiModel(value="AnswerExample",description="调查问卷问题回复对象")
public class AnswerExample {

    @ApiModelProperty(value="调查问卷id",required=true)
    private Long questionnaireId;

    @ApiModelProperty(value="问卷问题回复列表",required=true)
    private ArrayList<Answer> answers;

    public Long getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Long questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }
}
