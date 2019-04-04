package com.zr.gansu.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel(value="Banner",description="Banner图对象")
public class Banner {

    private Long id;

    @ApiModelProperty(value="图片名称",required=true)
    private String bannerName;

    @ApiModelProperty(value="图片存储路径",required=true)
    private String bannerSrc;

    private Integer sort;

    @ApiModelProperty(value="展示状态",hidden=true)
    private Integer status;

    @ApiModelProperty(value="创建时间",hidden=true)
    private Date gmtCreate;

    @ApiModelProperty(value="更新时间",hidden=true)
    private Date gmtModified;

    @ApiModelProperty(value="删除状态",hidden=true)
    private Integer isDeleted;

    public Banner(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName == null ? null : bannerName.trim();
    }

    public String getBannerSrc() {
        return bannerSrc;
    }

    public void setBannerSrc(String bannerSrc) {
        this.bannerSrc = bannerSrc == null ? null : bannerSrc.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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