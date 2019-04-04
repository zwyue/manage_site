package com.zr.gansu.web.controller;

import cn.hutool.core.collection.CollUtil;
import com.zr.gansu.common.log.Log;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.Site;
import com.zr.gansu.service.SiteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: yufei
 * @Description: 前台子站的操作
 * @Date: Create in 10:40 2018/12/24
 */
@Api(value="子站controller",tags={"子站接口操作"})
@RestController
@RequestMapping("/member/site")
public class SiteController {

    private final
    SiteService siteService;

    @Autowired
    public SiteController(SiteService siteService) {
        this.siteService = siteService;
    }


    /**
     *@Author:yufei
     *@Description: 查询子站列表
     *@Param:  null
     *@return java.util.Map
     *@Date: 2019/2/20_17:33
     */
    @Log
    @ApiOperation(value="查询子站列表", notes="查询子站列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Map getSiteList(){
        List<Site> siteList= siteService.getSiteList();
        return ResultUtils.success(siteList);
    }

    /**
     *@Author:yufei
     *@Description: 查询子站的用户数量
     *@Param:  null
     *@return java.util.Map
     *@Date: 2019/2/20_17:45
     */
    @Log
    @ApiOperation(value="查询子站的用户量", notes="查询子站的用户量")
    @RequestMapping(value = "/count/user",method = RequestMethod.GET)
    public Map countUsers(){
        List<Map<Long,Integer>> users = siteService.countUsers();
      if (CollUtil.isNotEmpty(users)){
          return ResultUtils.success(users);
      }else{
          return ResultUtils.error(ResultMsg.FIND_ERROR.msg());
      }
    }

    /**
     *@Author:yufei
     *@Description: 查询子站的总积分值
     *@Param:  null
     *@return java.util.Map
     *@Date: 2019/2/20_17:45
     */
    @Log
    @ApiOperation(value="查询子站的总学分值", notes="查询子站的总学分值")
    @RequestMapping(value = "/count/credit",method = RequestMethod.GET)
    public Map CountCredits(){
        List<Map<Long,Integer>> credits = siteService.countCredits();
        if (CollUtil.isNotEmpty(credits)){
            return ResultUtils.success(credits);
        }else{
            return ResultUtils.error(ResultMsg.FIND_ERROR.msg());
        }
    }
}
