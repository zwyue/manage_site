package com.zr.gansu.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author kaizhang
 */
@ApiModel(value="Question",description="调查问卷问题对象")
public class Question {
    private Long id;

    @ApiModelProperty(value="问卷标题",required=true)
    private String question;

    @ApiModelProperty(value="问卷标题",required=true)
    private Long questionnaireId;

    @ApiModelProperty(value="问卷标题",required=true)
    private Integer questionNo;

    @ApiModelProperty(value="问卷标题",required=true)
    private Integer type;

    @ApiModelProperty(value="更新时间",hidden=true)
    private Date gmtCreate;

    @ApiModelProperty(value="更新时间",hidden=true)
    private Date gmtModified;

    @ApiModelProperty(value="更新时间",hidden=true)
    private Integer isDeleted;


    private ArrayList<Option> options;

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public Long getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Long questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public Integer getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(Integer questionNo) {
        this.questionNo = questionNo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}