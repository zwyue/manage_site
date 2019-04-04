package com.zr.gansu.web.controller;

import com.zr.gansu.common.log.Log;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.service.ThemeColorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: yufei
 * @Description:网站主题颜色Controller
 * @Date: Create in 13:17 2019/1/24
 */
@Api(value="网站主题色controller",tags={"网站主题色接口操作"})
@RestController
@RequestMapping("/memner/theme")
public class ThemeColorController {

    private final
    ThemeColorService themeColorService;


    @Autowired
    public ThemeColorController(ThemeColorService themeColorService) {
        this.themeColorService = themeColorService;
    }

    /**
     *@Author:yufei
     *@Description:查询主题颜色
     *@Param:  null
     *@return java.util.Map
     *@Date:2019/1/24_13:24
     */
    @Log
    @ApiOperation(value="查询网站首页主题色", notes="查询网站首页主题色")
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public Map getThemeColor(){
       return  ResultUtils.success(themeColorService.getThemeEnable());
    }
}
