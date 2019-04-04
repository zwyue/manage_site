package com.zr.gansu.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 *@ClassName TeachingResourceForm
 *@Desciption 教学资源入参类
 *@Author Administrator
 *@Date 2019/2/20 10:14
 *@return
 */
@ApiModel(value = "教学资源参数",description = "教学资源传入参数")
public class TeachingResourceForm {
    /**
     * 教学资源主键
     */
    @ApiModelProperty(value = "教学资源主键")
    private Long id;
    /**
     * 资源标题
     */
    @ApiModelProperty(value = "资源标题",required = true)
    private String title;

    /**
     * 资源描述
     */
    @ApiModelProperty(value = "资源描述",required = true)
    private String description;

    /**
     * 资源类型： 0：视频  ，1：图文：html
     */
    @ApiModelProperty(value = "资源类型(修改时该值不能修改)：0：视频，1：图文",required = true)
    private String type;

    /**
     * 教学资源内容：type:0 视频地址， 1：html
     */
    @ApiModelProperty(value = "教学资源内容：type:0 视频地址， 1：html",required = true)
    private String contentText;
    /**
     * 缩略图地址
     */
    @ApiModelProperty(value = "缩略图地址",required = true)
    private String thumbnail;

    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者")
    private String creator;
    /**
     * 设置推荐 0否 1是
     */
    @ApiModelProperty(value = "设置推荐 0否 1是")
    private Integer isRecommend;

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
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
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
