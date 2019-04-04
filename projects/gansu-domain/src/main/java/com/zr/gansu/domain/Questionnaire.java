package com.zr.gansu.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
/**
 * @author kaizhang
 */
@ApiModel(value="Questionnaire",description="调查问卷对象")
public class Questionnaire {
    private Long id;

    @ApiModelProperty(value="问卷标题",required=true)
    private String title;

    @ApiModelProperty(value="作者id",hidden=true)
    private Long creatorId;

    @ApiModelProperty(value="课程id",required=true)
    private Long courseId;

    @ApiModelProperty(value="创建时间",hidden=true)
    private Date gmtCreate;

    @ApiModelProperty(value="更新时间",hidden=true)
    private Date gmtModified;

    @ApiModelProperty(value="删除状态",hidden=true)
    private Integer isDeleted;

    @ApiModelProperty(value="问卷发布状态",hidden=true)
    private Integer status;

    @ApiModelProperty(value="问题列表",hidden=true)
    private ArrayList<Question> questions;

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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