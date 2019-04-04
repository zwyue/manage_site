package com.zr.gansu.web.auth;

import com.zr.gansu.common.auth.UserDetail;
import com.zr.gansu.common.utils.BodyReaderHttpServletRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.social.security.SocialUser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description: 获取用户信息
 * @author: KaiZhang
 * @create: 2019-03-15 14:15
 **/
@Component
public class CurrentUser {

    Logger logger = LoggerFactory.getLogger(CurrentUser.class);

    public Long getCurrentUserId(HttpServletRequest request){
        //1.从HttpServletRequest中获取SecurityContextImpl对象
        SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
        //2.从SecurityContextImpl中获取Authentication对象
        Authentication authentication = securityContextImpl.getAuthentication();
        Object obj1 = authentication.getPrincipal();
        //尝试使用两种用户对用户信息进行匹配
        try {
            UserDetail userDetail = (UserDetail) obj1;
            return userDetail.getId();
        }catch (Exception e){
            logger.info("GetCurrentUserInfo转换成UserDetail失败,尝试转换成SocialUser",e);
            try {
                SocialUser socialUser = (SocialUser) obj1;
                return Long.parseLong(socialUser.getUserId());
            }catch (Exception e1){
                logger.error("转换用户信息失败!",e1);
            }
        }
        //获取用户信息失败,返回null,交由上层处理
        return null;
    }
}
