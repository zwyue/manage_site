package com.zr.gansu.vo;

import lombok.Data;

/**
 * CourseVo
 *
 * @author yuyi
 */
@Data
public class CourseVo {

    /**
     * 主键
     */
    private Long id;

    /**
     * 课程标题
     */
    private String title;

    /**
     * 缩略图
     */
    private String thumbnail;

    /**
     * 作者ID
     */
    private String authorId;

    /**
     * 类别ID
     */
    private Integer typeId;

    /**
     * 标签ID
     */
    private Long tagId;

    /**
     * 课程简介
     */
    private String description;

    /**
     * 课程状态
     */
    private Integer auditStatus;

    /**
     * 星级
     */
    private Integer starLevel;

    /**
     * 更新状态
     */
    private Integer status;

    /**
     * 浏览人数
     */
    private Long viewCount;

    /**
     * 收藏人数
     */
    private Long collectionCount;

    /**
     * 被加入学习计划数量
     */
    private Long addStudyCount;

    /**
     * 课程作者
     */
    private UserVo author;

    /**
     * 课程标签
     */
    private CourseTagVo courseTag;

}