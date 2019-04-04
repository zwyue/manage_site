package com.zr.gansu.web.controller;


import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageInfo;
import com.zr.gansu.common.log.Log;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.service.PopularActivityService;
import com.zr.gansu.vo.PopularActivityVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 *@ClassName PopularActivityController
 *@Desciption 热门活动控制层
 *@Author wanglidong
 *@Date 2019/2/13 11:37
 *@return
 */
@Api(value = "前台显示热门活动信息",tags = "查询热门活动信息")
@Controller
@RequestMapping("/popular")
public class PopularActivityController {
    @Resource
    private PopularActivityService popularActivityService;

    /***
     * @Author wanglidong
     * @Description 查询所有的热门活动信息
     * @Date 2019/2/13 13:30
     * @Param [pageNum, pageSize]
     * @return java.util.Map
     **/
    @Log
    @ApiOperation(value = "查询热门活动",notes ="分页查询热门活动")
    @ResponseBody
    @Transactional(rollbackFor=Exception.class)
    @RequestMapping(value = "/activity",method = RequestMethod.GET)
    public Map queryActivity(
            @ApiParam(name ="pageNum",value = "当前页码数",required = true)
            @RequestParam(name = "pageNum",defaultValue ="1") Integer pageNum,
            @ApiParam(name ="pageSize",value = "每页显示个数",required = true)
            @RequestParam(name = "pageSize",defaultValue ="10") Integer pageSize,
            @ApiParam(name ="siteId",value = "子站id",required = true)
            @RequestParam(name = "siteId") Long siteId){
        PageInfo pageInfo = popularActivityService.queryActivity(pageNum, pageSize,siteId);
        return ResultUtils.success(pageInfo,ResultMsg.SUCCESS.msg());
    }

    /***
     * @Author wanglidong
     * @Description  根据活动ID查询内容信息
     * @Date 2019/2/13 13:47
     * @Param [activityId]
     * @return java.util.Map
     **/
    @Log
    @ApiOperation(value = "查询热门活动内容",notes = "根据id查询活动内容")
    @ResponseBody
    @Transactional(rollbackFor=Exception.class)
    @RequestMapping(value = "/viewActivity",method = RequestMethod.GET)
    public Map viewActivityById(@ApiParam(name="activityId",value ="热门活动id",required = true)
                                @RequestParam(name="activityId") long activityId){
        PopularActivityVo popularActivityVo = popularActivityService.queryActivityVo(activityId);
        if(ObjectUtil.isNotNull(popularActivityVo)){
            //更新浏览量
            popularActivityService.updateActivityCounts(activityId);
            return ResultUtils.success(popularActivityVo,ResultMsg.SUCCESS.msg());
        }
        return ResultUtils.error("该条信息不存在，如有疑问联系管理员！");
    }

}
