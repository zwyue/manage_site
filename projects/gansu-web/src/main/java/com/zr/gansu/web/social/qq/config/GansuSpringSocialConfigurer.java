package com.zr.gansu.web.social.qq.config;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @description: 自定义登录和注册连接
 * @author: KaiZhang
 * @create: 2019-03-01 11:07
 **/
public class GansuSpringSocialConfigurer extends SpringSocialConfigurer {
//
//    private String filterProcessesUrl;
//
//    public GansuSpringSocialConfigurer(String filterProcessesUrl) {
//        this.filterProcessesUrl = filterProcessesUrl;
//    }

    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        filter.setFilterProcessesUrl("/login");
        filter.setSignupUrl("/my/user/social/sign/page.html");
        return (T) filter;
    }
}
