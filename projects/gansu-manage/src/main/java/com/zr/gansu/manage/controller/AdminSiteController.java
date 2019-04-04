package com.zr.gansu.manage.controller;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zr.gansu.common.log.Log;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.Site;
import com.zr.gansu.service.SiteService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: yufei
 * @Description: 后台子站controller操作
 * @Date: Create in 17:46 2019/2/20
 */
@Api(value="子站controller",tags={"子站接口操作"})
@RestController
@RequestMapping("/admin/site")
public class AdminSiteController {


    private final
    SiteService siteService;

    @Autowired
    public AdminSiteController(SiteService siteService) {
        this.siteService = siteService;
    }


    /**
     *@Author:yufei
     *@Description: 查询后台子站列表 分页展示
     *@Param: pageNum 当前页
     *@Param: pageSize 每页数量
     *@return java.util.Map
     *@Date: 2019/2/20_18:17
     */
    @Log
    @ApiOperation(value="查询后台子站列表", notes="查询后台子站列表",produces = "application/json")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Map getSiteList( @ApiParam(value = "当前分页数", required = true,defaultValue = "1") @RequestParam Integer pageNum,
                            @ApiParam(value = "每页数量", required = true,defaultValue = "10") @RequestParam Integer pageSize){
        //分页查询
        PageHelper.startPage(pageNum, pageSize, true);
        List<Site> siteList= siteService.getSiteList();
        return ResultUtils.success(new PageInfo<>(siteList));
    }

    /**
     *@Author:yufei
     *@Description:新增子站
     *@Param: site
     *@return java.util.Map
     *@Date:2019/1/24_13:06
     */
    @Log
    @ApiOperation(value="创建子站", notes="根据Site对象创建子站信息")
    @ApiResponses({
            @ApiResponse(code=1,message="添加成功"),
            @ApiResponse(code=0,message="添加失败")
    })
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Map addSite(@ApiParam(value = "子站参数", required = true) @RequestBody Site site){
        if(ObjectUtil.isNotNull(site)){
            site.setGmtCreate(new Date());
            if(siteService.insertSelective(site)>0){
                return ResultUtils.success(ResultMsg.ADD_SUCESS.msg());
            }
            return  ResultUtils.error(ResultMsg.ADD_ERROR.msg());
        }
        return ResultUtils.error(ResultMsg.ADD_SITE_NOTNULL.msg());
    }


    /**
     *@Author:yufei
     *@Description: 查询子站详情
     *@Param: id 子站id
     *@return java.util.Map
     *@Date: 2019/2/20_18:19
     */
    @Log
    @ApiOperation(value="查询子站详情", notes="根据url的id来指定查询子站")
    @ApiImplicitParam(name = "id", value = "子站ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public Map findSiteById(@PathVariable(value = "id") Long id){
        if(id != null){
            Site site = siteService.selectByPrimaryKey(id);
            if(ObjectUtil.isNotNull(site)){
                return ResultUtils.success(site);
            }
            return ResultUtils.error(ResultMsg.FIND_ERROR.msg());
        }
        return  ResultUtils.error(ResultMsg.ID_NOTNULL.msg());
    }

    /**
     *@Author:yufei
     *@Description: 修改子站信息
     *@Param: site  子站信息
     *@return java.util.Map
     *@Date: 2019/2/20_18:20
     */
    @Log
    @ApiOperation(value="更新子站", notes="根据Site对象更新子站信息")
    @ApiResponses({
            @ApiResponse(code=1,message="修改成功"),
            @ApiResponse(code=0,message="修改失败")
    })
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map updateSite(@ApiParam(value = "子站参数", required = true) @RequestBody Site site){
        if (ObjectUtil.isNotNull(site)) {
            site.setGmtModified(new Date());
            if(siteService.updateByPrimaryKeySelective(site)>0){
                return ResultUtils.success(ResultMsg.UPDATE_SUCESS.msg());
            }
            return ResultUtils.error(ResultMsg.UPDATE_ERROR.msg());
        }
        return ResultUtils.error(ResultMsg.ADD_SITE_NOTNULL.msg());
    }

    /**
     *@Author:yufei
     *@Description: 删除子站 逻辑删除
     *@Param: id 子站id
     *@return java.util.Map
     *@Date: 2019/2/20_18:21
     */
    @Log
    @ApiOperation(value="删除子站", notes="根据url的新闻id删除子站")
    @ApiImplicitParam(name = "id", value = "子站ID", required = true, dataType = "Long", paramType = "path")
    @ApiResponses({
            @ApiResponse(code=1,message="删除成功"),
            @ApiResponse(code=0,message="删除失败")
    })
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public Map deleteSite(@PathVariable(value = "id" )Long id){
        if(id != null){
            if(siteService.deleteByPrimaryKey(id)>0){
                return ResultUtils.success(ResultMsg.DELETE_SUCESS.msg());
            }
            return  ResultUtils.error(ResultMsg.DELETE_ERROR.msg());
        }
        return ResultUtils.error(ResultMsg.ID_NOTNULL.msg());
    }
}
