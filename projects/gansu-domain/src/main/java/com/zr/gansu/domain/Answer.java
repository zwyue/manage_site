package com.zr.gansu.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author kaizhang
 */
@ApiModel(value="Answer",description="问卷回复对象Answer")
public class Answer {
    private Long id;

    @ApiModelProperty(value="用户id",hidden=true)
    private Long userId;

    @ApiModelProperty(value="调查问卷id",hidden=true)
    private Long questionnaireId;

    @ApiModelProperty(value="问卷问题id",required=true)
    private Long questionId;

    @ApiModelProperty(value="问卷回复答案",required=true)
    private String answer;

    @ApiModelProperty(value="创建时间",hidden=true)
    private Date gmtCreate;

    @ApiModelProperty(value="更新时间",hidden=true)
    private Date gmtModified;

    @ApiModelProperty(value="删除状态",hidden=true)
    private Integer isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Long questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
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