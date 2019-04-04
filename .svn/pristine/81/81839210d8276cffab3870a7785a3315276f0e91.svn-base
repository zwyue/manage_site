package com.zr.gansu.web.controller;

import com.zr.gansu.common.auth.UserDetail;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.User;
import com.zr.gansu.web.auth.AuthService;
import com.zr.gansu.web.auth.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @description: 授权登录相关Controller
 * @author: KaiZhang
 * @create: 2019-02-26 16:23
 **/

@Controller
public class AuthUserController {


    @Autowired
    AuthService authService;

    @Autowired
    CurrentUser currentUser;

    /**
     * 用户密码（表单）登录
     * @param user user用户
     * @return 首页及用户信息
     */
    @RequestMapping(value = "/form/login" , method = RequestMethod.POST )
    @ResponseBody
    public Map userPasswordLogin(@RequestBody User user){
        return  authService.login(user.getLoginName(), user.getPassword());
    }

    /**
     * 用户注册
     */
    @RequestMapping(value = "/form/sign" , method = RequestMethod.POST)
    @ResponseBody
    public Map sign(@RequestBody UserDetail userDetail,HttpServletRequest request) {
        if (org.apache.commons.lang3.StringUtils.isAnyBlank(userDetail.getLoginName(), userDetail.getPassword())) {
           return ResultUtils.error("用户注册信息缺失，注册失败！");
        }
        return authService.register(userDetail,request);
    }

    /**
     * 获取用户信息
     */
    @RequestMapping(value = "/user/info" , method = RequestMethod.GET)
    @ResponseBody
    public Map getUserInfo(HttpServletRequest request) {
        Long userId = currentUser.getCurrentUserId(request);
        return ResultUtils.success(userId);
    }
}
