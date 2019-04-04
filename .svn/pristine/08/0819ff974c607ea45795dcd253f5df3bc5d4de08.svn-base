package com.zr.gansu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description: 用户登录Controller
 * @author: KaiZhang
 * @create: 2019-03-08 10:50
 **/
@Controller
@RequestMapping("/my/user")
public class LoginController {

    /**
     * 用户登录页跳转
     */
    @RequestMapping(value = "/login/page.html",method = RequestMethod.GET)
    public ModelAndView loginPage(){
        return new ModelAndView("/myLogin");
    }

    /**
     * 用户注册页跳转
     */
    @RequestMapping(value = "/sign/page.html",method = RequestMethod.GET)
    public ModelAndView signPage(){
        return new ModelAndView("/mySign");
    }


    /**
     * 社交用户注册页跳转
     */
    @RequestMapping(value = "/social/sign/page.html",method = RequestMethod.GET)
    public ModelAndView socialSign(){
        return new ModelAndView("/socialSign");
    }

    /**
     * 社交用户状态页跳转
     */
    @RequestMapping(value = "/social/status/page.html",method = RequestMethod.GET)
    public ModelAndView socialStatus(){
        return new ModelAndView("/socialStatus");
    }
}
