package com.zr.gansu.web.controller;

import com.github.pagehelper.PageInfo;
import com.zr.gansu.common.constants.Constants;
import com.zr.gansu.common.log.Log;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.OldAgeActivity;
import com.zr.gansu.domain.OldAgeActivityText;
import com.zr.gansu.service.OldAgeEduService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 老年教育 控制器
 *
 * @author yuyi
 */
@Api(value = "老年教育",tags = "老年教育")
@RestController
@RequestMapping("/oldAgeEdu")
public class OldAgeEduController {
    @Autowired
    private OldAgeEduService oldAgeEduService;


    @ApiOperation(value = "查询活动",notes ="分页查询活动")
    @GetMapping("/list")
    public Map listOldAgeActivity(
            @RequestParam Integer type,
            @ApiParam(name ="page",value = "当前页码数",required = true)
            @RequestParam(name = "page",defaultValue ="1") Integer page,
            @ApiParam(name ="size",value = "每页显示个数",required = true)
            @RequestParam(name = "size",defaultValue ="10") Integer size){
        if(!Constants.OldAgeEdu.ACTIVITY_TYPE_INTEREST.equals(type)
                && !Constants.OldAgeEdu.ACTIVITY_TYPE_OLD_AGE.equals(type)) {
            return ResultUtils.error("请传入合法type参数");
        }
        PageInfo pageInfo = oldAgeEduService.findByPagination(type,page,size);
        return ResultUtils.success(pageInfo,"查询成功");
    }

    @ApiOperation(value = "查询已参加的活动或课程",notes ="分页查询已参加的活动或课程")
    @GetMapping("/listByJoin")
    public Map listOldAgeActivityByJoin(
            @RequestParam Integer type,
            @ApiParam(name ="page",value = "当前页码数",required = true)
            @RequestParam(name = "page",defaultValue ="1") Integer page,
            @ApiParam(name ="size",value = "每页显示个数",required = true)
            @RequestParam(name = "size",defaultValue ="10") Integer size){
        if(!Constants.OldAgeEdu.ACTIVITY_TYPE_INTEREST.equals(type)
                && !Constants.OldAgeEdu.ACTIVITY_TYPE_OLD_AGE.equals(type)) {
            return ResultUtils.error("请传入合法type参数");
        }
        PageInfo pageInfo = oldAgeEduService.findByPaginationWithJoin(type,page,size);
        return ResultUtils.success(pageInfo,"查询成功");
    }

    /**
     * 查询活动明细
     *
     * @param id
     *
     * @return
     */
    @Log
    @ApiOperation(value = "查询活动明细",notes ="查询活动明细")
    @GetMapping("/details")
    public Map queryActivityDetails(Long id) {
        OldAgeActivity oldAgeActivity = oldAgeEduService.findByActivityId(id);
        return ResultUtils.success(oldAgeActivity,"查询成功");
    }

    /**
     * 查询老年活动内容明细
     *
     * @param id
     *
     * @return
     */
    @Log
    @ApiOperation(value = "查询活动内容明细",notes ="查询活动内容明细")
    @GetMapping("/contentDetails")
    public Map queryContentDetails(Long id) {
        OldAgeActivityText oldAgeActivityText = oldAgeEduService.findByContentId(id);
        return ResultUtils.success(oldAgeActivityText,"查询成功");
    }


    /**
     * 课程、活动报名
     */
    @Log
    @ApiOperation(value = "课程、活动报名",notes ="课程、活动报名")
    @PostMapping("/signUp")
    public Map SignUp(Long id,Integer type) {
        if(!Constants.OldAgeEdu.ACTIVITY_TYPE_INTEREST.equals(type)
                && !Constants.OldAgeEdu.ACTIVITY_TYPE_OLD_AGE.equals(type)) {
            return ResultUtils.error("请传入合法type参数");
        }
        return oldAgeEduService.signUp(id);
    }

    /**
     * 课程、活动 取消报名
     */
    @Log
    @ApiOperation(value = "课程、活动 取消报名",notes ="课程、活动 取消报名")
    @PostMapping("/signOut")
    public Map signOut(Long id,Integer type) {
        if(!Constants.OldAgeEdu.ACTIVITY_TYPE_INTEREST.equals(type)
                && !Constants.OldAgeEdu.ACTIVITY_TYPE_OLD_AGE.equals(type)) {
            return ResultUtils.error("请传入合法type参数");
        }
        return oldAgeEduService.signOut(id);
    }


    /**
     * 判断是否已参加课程或活动
     */
    @Log
    @ApiOperation(value = "判断是否已参加课程或活动",notes ="判断是否已参加课程或活动")
    @PostMapping("/isJoin")
    public Map isJoin(Long id, Integer type) {
        if(!Constants.OldAgeEdu.ACTIVITY_TYPE_INTEREST.equals(type)
                && !Constants.OldAgeEdu.ACTIVITY_TYPE_OLD_AGE.equals(type)) {
            return ResultUtils.error("请传入合法type参数");
        }
        return oldAgeEduService.isJoin(id);
    }


    /**
     * 课程或活动 签到
     */
    @Log
    @ApiOperation(value = "课程或活动 签到",notes ="课程或活动 签到")
    @PostMapping("/checkIn")
    public Map checkIn(Long id,Integer type) {
        if(!Constants.OldAgeEdu.ACTIVITY_TYPE_INTEREST.equals(type)
                && !Constants.OldAgeEdu.ACTIVITY_TYPE_OLD_AGE.equals(type)) {
            return ResultUtils.error("请传入合法type参数");
        }
        return oldAgeEduService.checkIn(id);
    }

    /**
     * 课程或活动 签退
     */
    @Log
    @ApiOperation(value = "课程或活动 签退",notes ="课程或活动 签退")
    @PostMapping("/signOff")
    public Map signOff(Long id,Integer type) {
        if(!Constants.OldAgeEdu.ACTIVITY_TYPE_INTEREST.equals(type)
                && !Constants.OldAgeEdu.ACTIVITY_TYPE_OLD_AGE.equals(type)) {
            return ResultUtils.error("请传入合法type参数");
        }
        return oldAgeEduService.signOff(id);
    }


}
