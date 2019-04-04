package com.zr.gansu.manage.controller;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zr.gansu.common.log.Log;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.ThemeColor;
import com.zr.gansu.service.ThemeColorService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: yufei
 * @Description:
 * @Date: Create in 13:27 2019/1/24
 */
@Api(value="主题颜色controller",tags={"网站主题接口操作"})
@RestController
@RequestMapping("/admin/theme")
public class AdminThemeColorController {

    @Resource
    private  ThemeColorService themeColorService;



    /**
     *@Author:yufei
     *@Description:查询所有主题
     *@Param: pageNum 当前页码
     *@Param: pageSize  每页数量
     *@return java.util.Map
     *@Date:2019/1/24_14:47
     */
    @Log
    @ApiOperation(value="查询后台网站主题颜色列表", notes="查询后台网站主题颜色列表",produces = "application/json")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Map getThemeAll(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                           @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
        //分页查询
       PageHelper.startPage(pageNum,pageSize,true);
       List<ThemeColor> themeColorList = themeColorService.getThemeColorAll();
        return ResultUtils.success(new PageInfo<>(themeColorList));
    }

    /**
     *@Author:yufei
     *@Description:新增主题
     *@Param: themeColor 主题信息
     *@return java.util.Map
     *@Date:2019/1/24_14:48
     */
    @Log
    @ApiOperation(value="创建主题颜色", notes="创建主题颜色")
    @ApiResponses({
            @ApiResponse(code=1,message="添加成功"),
            @ApiResponse(code=0,message="添加失败")
    })
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Map addTheme(@ApiParam(value = "主题颜色参数", required = true) @RequestBody ThemeColor themeColor){
        if(ObjectUtil.isNotNull(themeColor)){
            themeColor.setGmtCreate(new Date());
            if(themeColorService.insert(themeColor)>0){
                return ResultUtils.success(ResultMsg.ADD_SUCESS.msg());
            }
                return ResultUtils.error(ResultMsg.ADD_ERROR.msg());
        }
        return ResultUtils.error(ResultMsg.ADD_THEME_NOTNULL.msg());
    }

    /**
     *@Author:yufei
     *@Description: 查询主体信息详情
     *@Param: id
     *@return java.util.Map
     *@Date:2019/1/24_14:52
     */
    @Log
    @ApiOperation(value="查询主题色详情", notes="查询主题色详情")
    @ApiImplicitParam(name = "id", value = "主题色ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public Map getNewsByTagId(@PathVariable(value = "id") Long id){
        if(id != null){
            ThemeColor themeColor = themeColorService.selectByPrimaryKey(id);
            if(ObjectUtil.isNotNull(themeColor)){
                return ResultUtils.success(themeColor);
            }
            return ResultUtils.error(ResultMsg.FIND_ERROR.msg());
        }
        return  ResultUtils.error(ResultMsg.ID_NOTNULL.msg());
    }


    /**
     *@Author: yufei
     *@Description: 修改主题信息
     **@Param: themeColor  主题信息
     *@return java.util.Map
     *@Date: 2019/1/24_14:48
     */
    @Log
    @ApiOperation(value="更新主题色", notes="根据ThemeColor对象更新主题色")
    @ApiResponses({
            @ApiResponse(code=1,message="修改成功"),
            @ApiResponse(code=0,message="修改失败")
    })
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map updateThemeColor(@ApiParam(value = "主题色参数", required = true) @RequestBody ThemeColor themeColor){
        if(ObjectUtil.isNotNull(themeColor)){
            themeColor.setGmtCreate(new Date());
            if(themeColorService.updateByPrimaryKeySelective(themeColor)>0){
                return ResultUtils.success(ResultMsg.UPDATE_SUCESS.msg());
            }
            return ResultUtils.error(ResultMsg.UPDATE_ERROR.msg());
        }
        return ResultUtils.error(ResultMsg.ADD_THEME_NOTNULL.msg());
    }

    /**
     *@Author:yufei
     *@Description:删除主题信息
     *@Param: id
     *@return java.util.Map
     *@Date:2019/1/24_14:53
     */
    @Log
    @ApiOperation(value="删除主题色", notes="根据url的新闻id删除主题色")
    @ApiImplicitParam(name = "id", value = "主题ID", required = true, dataType = "Long", paramType = "path")
    @ApiResponses({
            @ApiResponse(code=1,message="删除成功"),
            @ApiResponse(code=0,message="删除失败")
    })
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public Map deleteTag(@PathVariable(value = "id" )Long id){
        if(id != null){
            //执行删除操作
            if(themeColorService.deleteByPrimaryKey(id)>0){
                return ResultUtils.success(ResultMsg.DELETE_SUCESS.msg());
            }
            return  ResultUtils.error(ResultMsg.DELETE_ERROR.msg());
        }
        return ResultUtils.error(ResultMsg.ID_NOTNULL.msg());
    }

}
