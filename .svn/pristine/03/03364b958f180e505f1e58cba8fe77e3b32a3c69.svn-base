package com.zr.gansu.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

/**
 *@ClassName NoticesVo
 *@Desciption 通知公告信息页面显示信息
 *@Author wanglidong
 *@Date 2019/2/13 10:56
 *@return
 */
@ApiModel(value = "通知公告vo",description = "通知公告view")
public  class NoticesVo {
    @ApiModelProperty(value = "通知公告id")
    private Long id;

    @ApiModelProperty(value ="通知公告标题")
    private String title;

    @ApiModelProperty(value ="通知公告创建人id")
    private Long creatorId;

    @ApiModelProperty(value ="创建时间")
    private Date gmtCreate;
    /**
     * 公告内容
     */
    @ApiModelProperty(value ="通知公告内容")
    private String content;

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

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }


    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
