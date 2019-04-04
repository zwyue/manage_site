package com.zr.gansu.domain;

/**
 * @description  热门活动内容
 * @author    Wg
 * @date     2019/02/12 14:32
 */
public class PopularActivityText {
    /**
     * 热门活动内容主键
     */
    private Long id;
    /**
     * 热门活动内容
     */
    private String contentText;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText == null ? null : contentText.trim();
    }
}