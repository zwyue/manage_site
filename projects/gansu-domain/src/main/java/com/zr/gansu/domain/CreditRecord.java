package com.zr.gansu.domain;

import java.util.Date;

public class CreditRecord {
    private Long id;

    private Long userId;

    private Integer type;

    private Integer changeCount;

    private Integer previousCredit;

    private Integer nowCredit;

    private Long newsId;

    private Long coursePeriodId;

    private Long goodsId;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer isDeleted;

    private String name;

    private Integer sun;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSun() {
        return sun;
    }

    public void setSun(Integer sun) {
        this.sun = sun;
    }

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(Integer changeCount) {
        this.changeCount = changeCount;
    }

    public Integer getPreviousCredit() {
        return previousCredit;
    }

    public void setPreviousCredit(Integer previousCredit) {
        this.previousCredit = previousCredit;
    }

    public Integer getNowCredit() {
        return nowCredit;
    }

    public void setNowCredit(Integer nowCredit) {
        this.nowCredit = nowCredit;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public Long getCoursePeriodId() {
        return coursePeriodId;
    }

    public void setCoursePeriodId(Long coursePeriodId) {
        this.coursePeriodId = coursePeriodId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
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