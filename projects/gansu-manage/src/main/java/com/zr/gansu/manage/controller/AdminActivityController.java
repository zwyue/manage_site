package com.zr.gansu.manage.controller;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.Activity;
import com.zr.gansu.domain.ActivityUser;
import com.zr.gansu.service.ActivityService;
import com.zr.gansu.service.ActivityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author WangGang
 * @description 活动控制类
 * @date 2018/12/26
 */
@Controller
@RequestMapping("/admin/activity")
public class AdminActivityController {

    final
    private ActivityService activityService;

    final
    private ActivityUserService activityUserService;

    @Autowired
    public AdminActivityController(ActivityService activityService, ActivityUserService activityUserService) {
        this.activityService = activityService;
        this.activityUserService = activityUserService;
    }

    /**
     *  管理员添加活动
     *
     * @author wanggang
     * @date 15:59 2018/12/26
     * @param activity 活动内容
     * @return 返回是否添加活动成功
     **/
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map postActivity(Activity activity,String contentText) {
        if (StringUtil.isNotEmpty(contentText) && ObjectUtil.isNotNull(activity)) {
            activity.setGmtCreate(new Date());
            activity.setGmtModified(new Date());
            int addCount =  activityService.addActivityContent(activity, contentText);
            if (addCount > 0) {
                return ResultUtils.success(ResultMsg.SUCCESS.msg());
            }
            return ResultUtils.error(ResultMsg.FAILED.msg());
        }
        return ResultUtils.error(ResultMsg.SYSTEM_INNER_ERROR.msg());
    }

    /**
     *  查询活动分页列表
     *
     * @Author WG
     * @Date 16:08 2019/3/15 0015
     * @Param activity 查询条件 pageNum，pageSize 分页参数
     * @return 活动分页信息
     */
    @ResponseBody
    @RequestMapping("/list")
    public Map queryActivityList(Activity activity) {
        List<Activity> list = activityService.queryActivity(activity);
        return ResultUtils.success(new PageInfo<>(list));
    }

    /**
     *  查询报名参加活动的志愿者
     * 
     * @author WG
     * @date 2019/2/19 16:10
     * @param activityId 活动主键Id
     * @return 报名活动的志愿者信息
     */
    @ResponseBody
    @RequestMapping(value = "/query/activity/volunteer/list", method = RequestMethod.GET)
    public Map activityVolunteerList(Long activityId) {
        if (activityId != null) {
            return ResultUtils.success(activityService.queryActivityUser(activityId));
        }
        return ResultUtils.error(ResultMsg.SYSTEM_INNER_ERROR.msg());
    }

    /**
     *  管理员删除活动
     *
     * @author wanggang
     * @date 11:23 2018/12/27
     * @param activity 条件
     * @return 是否删除成功
     **/
    @ResponseBody
    @RequestMapping("/deleted/activity")
    public Map deletedActivity(Activity activity) {
        if (ObjectUtil.isNotNull(activity) && ObjectUtil.isNotNull(activity.getId())) {
            //0：已删除
            activity.setIsDeleted(0);
            int count =  activityService.deleteActivity(activity);
            if (count > 0) {
                return ResultUtils.success(ResultMsg.SUCCESS.msg());
            }
            return ResultUtils.error(ResultMsg.FAILED.msg());
        }
        return ResultUtils.error(ResultMsg.SYSTEM_INNER_ERROR.msg());
    }

    /**
     *  管理员审核志愿者是否参加活动
     *
     * @author wanggang
     * @date 14:16 2018/12/27
     * @param activityUser 活动信息
     * @return 是否操作成功
     **/
    @ResponseBody
    @RequestMapping("/registration/audit/activities")
    public Map registrationAuditActivities(ActivityUser activityUser) {
        if (ObjectUtil.isNotNull(activityUser) && activityUser.getActivityId() != null
                && activityUser.getActivityState() != null) {
            int count = activityUserService.auditParticipateActivities(activityUser);
            if (count > 0) {
                return ResultUtils.success(ResultMsg.SUCCESS.msg());
            }
            return ResultUtils.error(ResultMsg.FAILED.msg());
        }
        return ResultUtils.error(ResultMsg.SYSTEM_INNER_ERROR.msg());
    }

    /**
     * 根据id查询活动详情
     *
     * @Author WG
     * @Date 15:34 2019/3/18 0018
     * @Param id 主键
     * @return 活动项目
     */
    @ResponseBody
    @RequestMapping("/details")
    public Map activitiesDetails(Long id) {
        if (id != null) {
           return ResultUtils.success(activityService.activitiesDetails(id),ResultMsg.SUCCESS.msg());
        }
        return ResultUtils.error(ResultMsg.SYSTEM_INNER_ERROR.msg());
    }

    /**
     * 修改活动
     *
     * @Author WG
     * @Date 16:51 2019/3/18 0018
     * @Param activity 更新信息
     * @return 是否更新成功
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map updateActivity(Activity activity) {
        if (activity.getId() != null && activity.getContentId() != null && ObjectUtil.isNotNull(activity) ) {
            if (activityService.updateActivity(activity) > 0 ) {
                return ResultUtils.success(ResultMsg.SUCCESS.msg());
            }
            return ResultUtils.error(ResultMsg.FAILED.msg());
        }
        return ResultUtils.error(ResultMsg.SYSTEM_INNER_ERROR.msg());
    }

}
