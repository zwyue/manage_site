package com.zr.gansu.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

/**
 *@ClassName PopularActivityForm
 *@Desciption 热门活动参数类
 *@Author wanglidong
 *@Date 2019/2/19 10:54
 *@return
 */
@ApiModel(value = "com.zr.gansu.form.PopularActivityForm",description ="热门活动参数类" )
public class PopularActivityForm {

    @ApiModelProperty(value = "活动id ")
    private Long id;
    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 子站ID
     */
    @ApiModelProperty(value = "子站ID")
    private Long siteId;
    /**
     * 活动地址
     */
    @ApiModelProperty(value = "活动地址")
    private String address;
    /**
     * 封面图地址
     */
    @ApiModelProperty(value = "封面图地址")
    private String urlCover;
    /**
     * 承办方
     */
    @ApiModelProperty(value = "承办方")
    private String undertake;

    /**
     * 活动开始时间
     */
    @ApiModelProperty(value = "活动开始时间", example = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:ss", timezone = "GMT+8")
    private Date startTime;

    /**
     * 活动结束时间
     */
    @ApiModelProperty(value = "活动结束时间", example = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:ss", timezone = "GMT+8")
    private Date endTime;

    /**
     * 热门活动内容
     */
    @ApiModelProperty(value = "热门活动内容")
    private String contentText;

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrlCover() {
        return urlCover;
    }

    public void setUrlCover(String urlCover) {
        this.urlCover = urlCover;
    }

    public String getUndertake() {
        return undertake;
    }

    public void setUndertake(String undertake) {
        this.undertake = undertake;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }
}
