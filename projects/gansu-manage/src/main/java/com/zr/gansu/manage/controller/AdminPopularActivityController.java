package com.zr.gansu.manage.controller;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageInfo;
import com.zr.gansu.common.constants.Constants;
import com.zr.gansu.common.log.Log;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.PopularActivity;
import com.zr.gansu.domain.PopularActivityText;
import com.zr.gansu.domain.Site;
import com.zr.gansu.form.PopularActivityForm;
import com.zr.gansu.service.PopularActivityService;
import com.zr.gansu.service.SiteService;
import com.zr.gansu.vo.PopularActivityVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Map;

/**
 *@ClassName PopularActivityController
 *@Desciption 热门活动控制层
 *@Author wanglidong
 *@Date 2019/2/13 11:37
 *@return
 */
@Api(value = "热门活动控制层",tags = "热门活动控制层")
@Controller
@RequestMapping("/admin/popular")
public class AdminPopularActivityController {
    @Resource
    private PopularActivityService popularActivityService;
    @Resource
    private SiteService siteService;
    /***
     * @Author wanglidong
     * @Description  添加热门活动
     * @Date 2019/2/13 12:59
     * @Param [popularActivity, contentText]
     * @return java.util.Map
    **/
    @Log
    @ApiOperation(value = "添加热门活动",notes ="添加热门活动内容")
    @ResponseBody
    @Transactional(rollbackFor=Exception.class)
    @RequestMapping(value = "/addActivity",method = RequestMethod.POST)
    public Map addPopularActivity(
            @ApiParam(value = "热门活动参数参数",required = true)
            @RequestBody PopularActivityForm popularActivityForm){
        if(ObjectUtil.isNotNull(popularActivityForm)&&ObjectUtil.isNotNull(popularActivityForm.getContentText())){
            //判断子站信息是否存在
            Site site = siteService.selectByPrimaryKey(popularActivityForm.getSiteId());
            if(ObjectUtil.isNotNull(site)&&Constants.IS_DELETED_NO.equals(site.getIsDeleted())){
                //先添加活动内容
            PopularActivityText popularActivityText=new PopularActivityText();
            popularActivityText.setContentText(popularActivityForm.getContentText());
                Integer statusText = popularActivityService.addActivityText(popularActivityText);
                if(!statusText.equals(Constants.EXECUTE_FAIL)){
                    //添加热门活动相关信息
                    PopularActivity popularActivity=new PopularActivity();
                    //对象映射
                    BeanUtils.copyProperties(popularActivityForm,popularActivity);
                    popularActivity.setContentId(popularActivityText.getId());
                    Integer status = popularActivityService.addActivity(popularActivity);
                    if(!status.equals(Constants.EXECUTE_FAIL)){
                        return ResultUtils.success("添加活动成功！");
                    }
                }
                return ResultUtils.error("添加热门活动信息失败！");
            }else{
                return ResultUtils.error("子站信息不存在！");
            }
        }
      return ResultUtils.error("活动相关信息不能为空！");
    }

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
                return ResultUtils.success(popularActivityVo,ResultMsg.SUCCESS.msg());
            }
        return ResultUtils.error("该条信息不存在，如有疑问联系管理员！");
    }

    /***
     * @Author wanglidong
     * @Description 更新热门内容信息
     * @Date 2019/2/13 14:44
     * @Param [popularActivity, contentText]
     * @return java.util.Map
    **/
    @Log
    @ApiOperation(value = "修改热门活动内容",notes = "根据Id修改热门活动内容")
    @ResponseBody
    @Transactional(rollbackFor=Exception.class)
    @RequestMapping(value = "/modifyActivity",method = RequestMethod.POST)
    public Map modifyActivityInfo(@ApiParam(value = "热门活动参数")@RequestBody PopularActivityForm popularActivityForm){
        if(ObjectUtil.isNotNull(popularActivityForm)&&ObjectUtil.isNotNull(popularActivityForm.getContentText())){
            //对象映射
            PopularActivity popularActivity=new PopularActivity();
            BeanUtils.copyProperties(popularActivityForm,popularActivity);
            Integer status = popularActivityService.modifyActivityInfo(popularActivity,popularActivityForm.getContentText());
            if(!status.equals(Constants.EXECUTE_FAIL)){
                return ResultUtils.success("修改成功！");
            }
        }
        return ResultUtils.error("修改热门活动失败！");
    }

    /***
     * @Author wanglidong
     * @Description 删除活动内容
     * @Date 2019/2/13 14:43
     * @Param [activityId]
     * @return java.util.Map
    **/
    @Log
    @ApiOperation(value = "删除活动",notes = "根据Id删除活动")
    @ResponseBody
    @Transactional(rollbackFor=Exception.class)
    @RequestMapping(value = "delActivity",method = RequestMethod.POST)
    public Map delActivityById( @ApiParam(name = "activityId",value = "热门活动id",required = true)
                                    @RequestParam(name="activityId")long activityId){
        Integer  delStatus = popularActivityService.delActivityById(activityId);
        if(!delStatus.equals(Constants.EXECUTE_FAIL)){
            if(delStatus.equals(Constants.IS_DELETED_ALREADY)){
              return ResultUtils.error("请勿重复操作!");
            }
            return ResultUtils.success("删除成功！");
        }
        return ResultUtils.error("删除热门活动失败！");
    }
}
