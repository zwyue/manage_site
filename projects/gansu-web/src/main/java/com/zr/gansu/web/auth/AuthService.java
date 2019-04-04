package com.zr.gansu.web.auth;

import com.zr.gansu.common.auth.UserDetail;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @description: 授权登录相关Service
 * @author: KaiZhang
 * @create: 2019-02-26 16:20
 **/
public interface AuthService {


    /**
     * 用户名密码登录
     * @param loginName 登录名
     * @param password  密码
     * @return userToken
     */
    Map login(String loginName, String password);


    /**
     * 注册用户
     * @param userDetail userDetail
     * @return UserDetail
     */
    Map register(UserDetail userDetail , HttpServletRequest request);


}
