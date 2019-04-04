package com.zr.gansu.manage.controller;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageInfo;
import com.zr.gansu.common.constants.Constants;
import com.zr.gansu.common.log.Log;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.form.TeachingResourceForm;
import com.zr.gansu.service.TeachingResourceService;
import com.zr.gansu.vo.TeachingResourceInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 *@ClassName AdminEducationResources
 *@Desciption 教学资源管理层
 *@Author wanglidong
 *@Date 2019/2/20 10:05
 */
@Api(value = "教学资源管理",tags = "教学资源管理")
@Controller
@RequestMapping("/admin/education")
public class AdminEducationResourcesController {

    @Resource
    private TeachingResourceService teachingResourceService;



    /***
     * @Author wanglidong
     * @Description 添加教学资源
     * @Date 2019/2/20 13:44
     * @Param [teachingResourceForm]
     * @return java.util.Map
    **/
    @Log
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    @ApiOperation(value = "添加教学资源",notes ="添加教学资源" )
    @RequestMapping(value = "/addResource",method = RequestMethod.POST)
    public Map addTeachingResource(@ApiParam(value = "教学资源参数")
                                   @RequestBody TeachingResourceForm teachingResourceForm){

        if(ObjectUtil.isNotNull(teachingResourceForm)){
            Integer addStatus = teachingResourceService.addTeachingResource(teachingResourceForm);
            if(!addStatus.equals(Constants.EXECUTE_FAIL)){
                return ResultUtils.success("添加成功!");
            }
        }
        return ResultUtils.error("添加失败!");
    }

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
    public Map queryTeachingResourceAll(@ApiParam(name="pageNum",value = "当前页码数")
                                @RequestParam(name="pageNume",defaultValue ="1") Integer pageNum,
                                @ApiParam(name="pageSize",value = "每页显示个数")
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
    public Map queryTeachingResourceByType(@ApiParam(name="pageNum",value = "当前页码数")
                                   @RequestParam(name="pageNum",defaultValue ="1") Integer pageNum,
                                   @ApiParam(name="pageSize",value = "每页显示个数")
                                   @RequestParam(name="pageSize",defaultValue ="10") Integer pageSize,
                                   @ApiParam(name="type",value = "查看的资源类型：0视频，1 图文（html）")
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
    public Map queryTeachingResourceById(@RequestParam(name ="id") Long id ){
        TeachingResourceInfoVo teachingResourceInfoVo = teachingResourceService.queryResourceInfoById(id);
        if(ObjectUtil.isNotNull(teachingResourceInfoVo)){
            return ResultUtils.success(teachingResourceInfoVo);
        }
        return ResultUtils.error("你查看的信息不存在!");
    }

    @Log
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    @ApiOperation(value = "修改教学资源",notes ="修改教学资源" )
    @RequestMapping(value = "/modifyResource",method = RequestMethod.POST)
    public Map modifyTeachingResource(@ApiParam(value = "教学资源参数")
                                      @RequestBody TeachingResourceForm teachingResourceForm){
        if(ObjectUtil.isNotNull(teachingResourceForm)){
            Integer modifyStatus = teachingResourceService.modifyTeachingResource(teachingResourceForm);
            if(!modifyStatus.equals(Constants.EXECUTE_FAIL)){
                return ResultUtils.success("修改成功!");
            }
        }
        return ResultUtils.error("修改失败!");
    }

    @Log
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    @ApiOperation(value = "删除教学资源",notes ="删除教学资源" )
    @RequestMapping(value = "/delResource",method = RequestMethod.POST)
    public Map TeachingResource(@ApiParam(name="id",value = "教学资源id",required = true) @RequestParam(name ="id") Long id){
        Integer delStatus = teachingResourceService.delTeachingResource(id);
        if(delStatus.equals(Constants.IS_DELETED_ALREADY)){
            return ResultUtils.error("请勿重复操作!");
        }else if(delStatus.equals(Constants.IS_DELETED_NO)){
            return ResultUtils.success("删除成功！");
        }
        return ResultUtils.error("删除失败!");
    }
}
