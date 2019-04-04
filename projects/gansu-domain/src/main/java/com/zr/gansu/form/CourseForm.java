package com.zr.gansu.form;

import lombok.Data;

/**
 * @ClassName CourseForm
 * @Author Administrator
 * @Date 2019/2/15 15:25
 */
@Data
public class CourseForm {

    /**
     * 标题
     **/
    private String title;

    /**
     * 封面缩略图
     **/
    private String thumbnail;

    /**
     * 课程老师
     **/
    private String authorId;

    /**
     * 课程类型
     **/
    private Integer typeId;

    /**
     * 标签
     **/
    private Long tagId;

    /**
     * 课程简介
     **/
    private String description;

    /**
     * 审核状态
     **/
    private Integer auditStatus;

    /**
     * 更新状态
     **/
    private Integer status;
}
