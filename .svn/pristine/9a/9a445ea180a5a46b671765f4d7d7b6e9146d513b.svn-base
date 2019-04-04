package com.zr.gansu.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author WangGang
 * @description 学习地图控制类
 * @date 2018/12/21
 */
@RestController
@RequestMapping("/member/studymap")
public class StudyMapController {

    /**
     * @author wanggang
     * @date 10:23 2018/12/22
     * @return 地图页面
     **/
    @RequestMapping("/tomap")
    public ModelAndView toMap() {
        return new ModelAndView("studyMap");
    }

    /**
     * 跳转地图页面
     *
     * @author WG
     * @date 2019/2/11 10:45
     * @return 页面地址
     */
    @RequestMapping("/map")
    public ModelAndView toTestMap() {
        return new ModelAndView("map");
    }

    /**
     * 跳转地图页面，多点标记
     *
     * @author WG
     * @date 2019/2/11 11:20
     * @return 地图页面
     */
    @RequestMapping("/maptwo")
    public ModelAndView toMapTwo() {
        return new ModelAndView("mapTwo");
    }
}
