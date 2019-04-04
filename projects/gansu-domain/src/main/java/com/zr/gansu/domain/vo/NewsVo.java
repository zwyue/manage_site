package com.zr.gansu.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;


/**
 * @Author: yufei
 * @Description:新闻VO类
 * @Date: Create in 9:16 2019/2/15
 */
@ApiModel(value="NewsVo",description="新闻Vo传输对象")
public class NewsVo {

    private Long id;

    private String description;

    private Long contentId;

    @ApiModelProperty(value="新闻内容",required=true)
    private String content;

    @ApiModelProperty(value="新闻标题",required=true)
    private String title;

    @ApiModelProperty(value="新闻标签",required=true)
    private Long tagId;

    @ApiModelProperty(value="新闻缩略图",required=true)
    private String thumbnail;

    @ApiModelProperty(value="子站id",hidden=true)
    private Long siteId;

    @ApiModelProperty(value="创建者",hidden=true)
    private String creator;

    @ApiModelProperty(value="创建时间",hidden=true)
    private  Date gmtCreate;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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
