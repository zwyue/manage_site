package com.zr.gansu.domain;

import lombok.Data;

import java.util.Date;

/**
 * 老年活动用户中间表
 *
 * @author yuyi
 *
 */
@Data
public class OldAgeActivityUser {

    /**
     * 主键
     */
    private Long id;

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 是否签到 ： 0 - 未签到 ，1 - 已签到
     */
    private Integer checkIn;

    /**
     * 是否签退：0 - 未签退 ，1 - 已签退
     */
    private Integer signOff;

    /**
     * 签到时间
      */
    private Date checkInTime;

    /**
     * 签退时间
     */
    private Date signOffTime;
}