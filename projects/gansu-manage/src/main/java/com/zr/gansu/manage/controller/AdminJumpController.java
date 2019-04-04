package com.zr.gansu.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/jump")
public class AdminJumpController {

    /**
     * 跳转欢迎页面
     *
     * @author WG
     * @date 2019/3/13 16:15
     */
    @RequestMapping("/welcome")
    public ModelAndView toWelcome() {
        return new ModelAndView("welcome");
    }

    /**
     * 跳转到新闻列表页面
     *
     * @author WG
     * @date 2019/3/14 13:29
     */
    @RequestMapping("/new/table")
    public ModelAndView toNewTable() {
        return new ModelAndView("new_table");
    }

    /**
     * 跳转到新闻添加页面
     *
     * @author WG
     * @date 2019/3/14 14:06
     */
    @RequestMapping("/new/add")
    public ModelAndView toAddNew() {
        return new ModelAndView("new_add");
    }

    /**
     *  跳转到活动列表页面
     *
     * @Author WG
     * @Date 10:25 2019/3/15 0015
     */
    @RequestMapping("/activity/list")
    public ModelAndView toActivity() {
        return new ModelAndView("activity_look");
    }

    /**
     * 跳转到活动添加页面
     *
     * @Author WG
     * @Date 15:19 2019/3/15 0015
     */
    @RequestMapping("/activity/add")
    public ModelAndView toAddActivity() {
        return new ModelAndView("activity_add");
    }

    /**
     *  跳转到活动修改页面
     *
     * @Author WG
     * @Date 15:18 2019/3/18 0018
     */
    @RequestMapping("/activity/update")
    public ModelAndView toUpdateActivity() {
        return new ModelAndView("activity_update");
    }


}
