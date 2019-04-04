package com.zr.gansu.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 老年活动
 *
 * @author yuyi
 */
@Data
public class OldAgeActivity {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 活动内容id
     */
    private Long contentId;
    /**
     * 活动地址
     */
    private String address;
    /**
     * 封面图地址
     */
    private String coverUrl;
    /**
     * 承办方
     */
    private String organizer;
    /**
     * 浏览量
     */
    private int viewCount;
    /**
     * 创建者的id
     */
    private long creatorId;

    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 更新时间
     */
    private Date gmtModified;

    /**
     * 是否删除 0未，1已删除
     */
    private Integer isDeleted;

    /**
     * 活动开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date startTime;

    /**
     * 活动结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endTime;

    /**
     * 参加总人数
     */
    private Integer totalPeople;

    /**
     * 活动类型 ： 1 - 老年活动，2 - 兴趣课程
     */
    private Integer type;

}