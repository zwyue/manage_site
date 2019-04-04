package com.zr.gansu.web.validate.code;


import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @description: 图形验证码
 * @author: KaiZhang
 * @create: 2019-03-10 13:39
 **/
public class ImageCode {
    /**
     * 图片
     */
    private BufferedImage image;

    /**
     * 验证码内容
     */
    private String code;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;


    public ImageCode(BufferedImage image, String code, int expireIn) {
        this.image = image;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }

    /**
     * 是否过期
     * @return 是否过期
     */
    public boolean isExpried() {
        return this.expireTime.isBefore(LocalDateTime.now());
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}
