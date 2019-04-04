package com.zr.gansu.domain;

/**
 * @description  活动用户中间表
 * @author    Wg
 * @date     2018/12/25 9:32
 */
public class ActivityUser {
    private Long id;

    private Long activityId;

    private Long userId;

    private Integer activityState;

    private String name;

    public Integer getActivityState() {
        return activityState;
    }

    public void setActivityState(Integer activityState) {
        this.activityState = activityState;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}