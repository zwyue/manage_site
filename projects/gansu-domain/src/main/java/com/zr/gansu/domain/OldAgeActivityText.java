package com.zr.gansu.domain;

import lombok.Data;

/**
 * 老年活动内容
 *
 * @author yuyi
 */
@Data
public class OldAgeActivityText {
    /**
     * 活动内容主键
     */
    private Long id;
    /**
     * 活动内容
     */
    private String contentText;
}