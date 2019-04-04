package com.zr.gansu.manage.controller;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zr.gansu.common.log.Log;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.Banner;
import com.zr.gansu.service.BannerService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: yufei
 * @Description:后台banner图 Controller
 * @Date: Create in 9:37 2019/1/25
 */
@Api(value="Banner图片",tags={"Banner图片操作接口"})
@RestController
@RequestMapping("/admin/banner")
public class AdminBannerController {

    @Resource
    private BannerService bannerService;

    /**
     *@Author:yufei
     *@Description:查询banner图列表
     *@Param: pageNum
     *@Param: pageSize
     *@return java.util.Map
     *@Date:2019/1/25_9:50
     */
    @Log
    @ApiOperation(value="查询后台Banner图片列表", notes="查询后台Banner图片列表",produces = "application/json")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Map getBannerList(@ApiParam(value = "当前分页数", required = true,defaultValue = "1")@RequestParam Integer pageNum,
                             @ApiParam(value = "每页数量", required = true,defaultValue = "10")@RequestParam Integer pageSize){
        //分页查询
        PageHelper.startPage(pageNum,pageSize,true);
        List<Banner> bannerList = bannerService.getBannerBackList();
        return ResultUtils.success(new PageInfo<>(bannerList));
    }

    /**
     *@Author:yufei
     *@Description:新增banner图
     *@Param: banner
     *@return java.util.Map
     *@Date:2019/1/25_9:44
     */
    @Log
    @ApiOperation(value="添加Banner图片", notes="根据Banner对象创建新闻信息")
    @ApiResponses({
            @ApiResponse(code=1,message="添加成功"),
            @ApiResponse(code=0,message="添加失败")
    })
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Map insertBanner(@ApiParam(value = "Banner图参数", required = true) @RequestBody Banner banner){
        if(ObjectUtil.isNotNull(banner)){
            banner.setGmtCreate(new Date());
            if( bannerService.insert(banner)>0){
                return ResultUtils.success(ResultMsg.ADD_SUCESS.msg());
            }
            return ResultUtils.error(ResultMsg.ADD_ERROR.msg());
        }
        return ResultUtils.error(ResultMsg.ADD_BANNER_NOTNULL.msg());
    }

    /**
     *@Author:yufei
     *@Description:修改banner图信息
     *@Param: banner
     *@return java.util.Map
     *@Date:2019/1/25_9:47
     */
    @Log
    @ApiOperation(value="更新Banner图片", notes="根据Banner对象更新图片信息")
    @ApiResponses({
            @ApiResponse(code=1,message="修改成功"),
            @ApiResponse(code=0,message="修改失败")
    })
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public Map updateBanner(@ApiParam(value = "新闻参数", required = true) @RequestBody Banner banner){
        if(ObjectUtil.isNotNull(banner)){
            banner.setGmtModified(new Date());
            if(bannerService.updateByPrimaryKeySelective(banner)>0){
                return ResultUtils.success(ResultMsg.UPDATE_SUCESS.msg());
            }
            return ResultUtils.error(ResultMsg.UPDATE_ERROR.msg());
        }
        return ResultUtils.error(ResultMsg.ADD_BANNER_NOTNULL.msg());
    }

    /**
     *@Author:yufei
     *@Description:查询banner图详情
     *@Param: id
     *@return java.util.Map
     *@Date:2019/1/25_9:57
     */
    @Log
    @ApiOperation(value="查询Banner图详情", notes="根据url的id来指定查询Banner图")
    @ApiImplicitParam(name = "id", value = "Banner图ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public Map getBannerById(@PathVariable(value = "id") Long id){
        if(id != null){
            Banner banner = bannerService.selectByPrimaryKey(id);
            if(ObjectUtil.isNotNull(banner)){
                return ResultUtils.success(banner);
            }
            return ResultUtils.error(ResultMsg.FIND_ERROR.msg());
        }
        return  ResultUtils.error(ResultMsg.ID_NOTNULL.msg());
    }

    /**
     *@Author:yufei
     *@Description:删除banner图信息 逻辑删除
     *@Param: id
     *@return java.util.Map
     *@Date:2019/1/25_9:59
     */
    @Log
    @ApiOperation(value="删除Banner图片", notes="根据url的新闻id删除Banner图")
    @ApiImplicitParam(name = "id", value = "Banner图ID", required = true, dataType = "Long", paramType = "path")
    @ApiResponses({
            @ApiResponse(code=1,message="删除成功"),
            @ApiResponse(code=0,message="删除失败")
    })
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public Map deleteBanner(@PathVariable(value = "id" )Long id){
        if(id != null){
            if(bannerService.deleteBanner(id)>0){
                return ResultUtils.success(ResultMsg.DELETE_SUCESS.msg());
            }
            return  ResultUtils.error(ResultMsg.DELETE_ERROR.msg());
        }
        return ResultUtils.error(ResultMsg.ID_NOTNULL.msg());
    }
}
