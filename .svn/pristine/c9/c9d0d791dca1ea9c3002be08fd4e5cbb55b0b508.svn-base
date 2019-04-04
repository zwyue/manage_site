package com.zr.gansu.web.controller;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageInfo;
import com.zr.gansu.common.constants.Constants;
import com.zr.gansu.common.log.Log;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.TeachingResource;
import com.zr.gansu.service.TeachingResourceService;
import com.zr.gansu.vo.TeachingResourceInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *@ClassName EducationResourcesController
 *@Desciption 教学资源
 *@Author wanglidong
 *@Date 2019/2/20 16:41
 */
@Api(value = "教学资源展示(前端)",tags = "教学资源展示")
@Controller
@RequestMapping("/education")
public class EducationResourcesController {

    @Resource
    private TeachingResourceService teachingResourceService;

    /***
     * @Author wanglidong
     * @Description 查询全部教学资源
     * @Date 2019/2/20 13:44
     * @Param [pageNum, pageSize]
     * @return java.util.Map
     **/
    @Log
    @ResponseBody
    @ApiOperation(value = "查询全部教学资源",notes = "查询全部教学资源")
    @RequestMapping(value = "/queryAll",method = RequestMethod.GET)
    public Map queryTeachingResourceAll(@ApiParam(name="pageNum",value = "当前页码数",required = true)
                                        @RequestParam(name="pageNum",defaultValue ="1") Integer pageNum,
                                        @ApiParam(name="pageSize",value = "每页显示个数",required = true)
                                        @RequestParam(name="pageSize",defaultValue ="10") Integer pageSize){
        PageInfo pageInfo = teachingResourceService.queryAll(pageNum, pageSize);
        return ResultUtils.success(pageInfo, ResultMsg.SUCCESS.msg());
    }

    /**
     * @Author wanglidong
     * @Description 根据资源类型查询教学资源
     * @Date 2019/2/20 13:58
     * @Param [pageNum, pageSize, type]
     * @return java.util.Map
     **/
    @Log
    @ResponseBody
    @ApiOperation(value = "根据资源类型查询教学资源",notes = "根据资源类型查询教学资源")
    @RequestMapping(value = "/queryByType",method = RequestMethod.GET)
    public Map queryTeachingResourceByType(@ApiParam(name="pageNum",value = "当前页码数",required = true)
                                           @RequestParam(name="pageNum",defaultValue ="1") Integer pageNum,
                                           @ApiParam(name="pageSize",value = "每页显示个数",required = true)
                                           @RequestParam(name="pageSize",defaultValue ="10") Integer pageSize,
                                           @ApiParam(name="type",value = "查看的资源类型：0视频，1 图文（html）",required = true)
                                           @RequestParam(name="type") String type){
        PageInfo pageInfo = teachingResourceService.queryResourceByType(pageNum, pageSize, type);
        return ResultUtils.success(pageInfo, ResultMsg.SUCCESS.msg());
    }

    /**
     * @Author wanglidong
     * @Description 根据资源Id查询教学资源信息
     * @Date 2019/2/20 14:08
     * @Param [id]
     * @return java.util.Map
     **/
    @Log
    @ResponseBody
    @ApiOperation(value = "根据资源Id查询教学资源信息",notes = "根据资源Id查询教学资源信息")
    @RequestMapping(value = "/queryById",method = RequestMethod.GET)
    public Map queryTeachingResourceById(@ApiParam(name="id",value = "根据id查询教学资源",required = true)@RequestParam(name ="id") Long id ){
        TeachingResourceInfoVo teachingResourceInfoVo = teachingResourceService.queryResourceInfoById(id);
        if(ObjectUtil.isNotNull(teachingResourceInfoVo)){
            //更新浏览量
            teachingResourceService.updateTeachingResourceViewCounts(id);
            return ResultUtils.success(teachingResourceInfoVo);
        }
        return ResultUtils.error("你查看的信息不存在!");
    }


    /**
     * @Author wanglidong
     * @Description  点赞操作 根据查看资源id 成功返回点赞后的点赞量；
     * @Date 2019/2/20 17:28
     * @Param [id]
     * @return java.util.Map
    **/
    @Log
    @ResponseBody
    @ApiOperation(value = "根据id更新点赞量:返回点赞量",notes = "根据id更新点赞量:返回点赞量")
    @RequestMapping(value = "/updateLikeCounts",method = RequestMethod.POST)
    public Map updateLikeCounts(@ApiParam(name="id",value ="根据id更新点赞量:返回点赞量")
                                @RequestParam(name ="id") Long id ){
        Long likeCounts = teachingResourceService.updateTeachingResourceLikeCounts(id);
        if(!likeCounts.equals(0L)){
                return ResultUtils.success(likeCounts,ResultMsg.SUCCESS.msg());
        }else{
            //更新失败
            return ResultUtils.error(ResultMsg.FAILED.msg());
        }
    }

    @Log
    @ResponseBody
    @ApiOperation(value = "推荐的4个资源列表(不分资源类型)",notes = "推荐的4个资源列表")
    @RequestMapping(value = "/recommendAll",method = RequestMethod.GET)
    public Map  recommendTeachingResource(){
        List<TeachingResource> teachingResources = teachingResourceService.teachingResource(null);
        return ResultUtils.success(teachingResources);
    }

    @Log
    @ResponseBody
    @ApiOperation(value = "推荐的4个资源列表(分资源类型)",notes = "推荐的4个资源列表")
    @RequestMapping(value = "/recommendByType",method = RequestMethod.GET)
    public Map  recommendTeachingResourceByType(@ApiParam(name="type",value = "资源类型:0 视频 1 图文",required = true) @RequestParam(name ="type")  String type){
        List<TeachingResource> teachingResources = teachingResourceService.teachingResource(type);
        return ResultUtils.success(teachingResources);
    }
}