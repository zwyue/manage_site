package com.zr.gansu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 页面跳转控制类
 *
 * @Author WG
 * @Date 14:41 2019/3/18 0018
 */
@Controller
@RequestMapping("/member/skip")
public class SkipController {

    @RequestMapping("/")
    public ModelAndView skipNew(){
        return new ModelAndView("new_info");
    }

    /**
     * 跳转到学分商城页面
     *
     * @Author WG
     * @Date 14:42 2019/3/18 0018
     */
    @RequestMapping("/shop")
    public ModelAndView skipShop(){
        return new ModelAndView("creditShopping/creditShop");
    }
}
