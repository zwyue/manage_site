package com.zr.gansu.web.controller;

import com.zr.gansu.common.log.Log;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.Banner;
import com.zr.gansu.service.BannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: yufei
 * @Description:前台banner图片Controller
 * @Date: Create in 9:28 2018/12/19
 */
@Api(value="Banner图controller",tags={"Banner图片接口操作"})
@RestController
@RequestMapping("/member/banner")
public class BannerController {

    private final
    BannerService bannerService;

    @Autowired
    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    /**
     *@Author:yufei
     *@Description: 查询banner图列表
     *@return java.util.Map
     *@Date: 2019/1/25_9:50
     */
    @Log
    @ApiOperation(value="查询Banner图片列表", notes="查询Banner图片列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Map findBannerList(){
        List<Banner> bannerList = bannerService.getBannerAll();
        return ResultUtils.success(bannerList);
    }

}
