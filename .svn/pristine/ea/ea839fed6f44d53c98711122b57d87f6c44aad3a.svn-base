package com.zr.gansu.web.controller;

import cn.hutool.core.util.ObjectUtil;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.ActivityUser;
import com.zr.gansu.domain.User;
import com.zr.gansu.service.ActivityUserService;
import com.zr.gansu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @description: 用户Controller
 * @author: KaiZhang
 * @create: 2018-12-15 16:54
 **/
@RestController
@RequestMapping("/member/user")
public class UserController {

    private final UserService userService;

    private final ActivityUserService activityUserService;

    @Autowired
    public UserController(ActivityUserService activityUserService, UserService userService) {
        this.activityUserService = activityUserService;
        this.userService = userService;
    }

    /**
     *  申请成为志愿者
     *
     * @author wanggang
     * @date 11:02 2018/12/24
     * @param user 用户信息
     * @return 是否申请成功
     **/
    @ResponseBody
    @RequestMapping("/applyforvolunteer")
    public Map volunteerApplication(User user) {
        if(ObjectUtil.isNotNull(user) && user.getId() != null) {
            return userService.volunteerApplication(user);
        }
        return ResultUtils.success(ResultMsg.SYSTEM_INNER_ERROR.msg());
    }

    /**
     * 根据主键获取用户详细信息
     *
     * @author WG
     * @date 2019/2/13 16:27
     * @param id 用户主键
     * @return 用户详细信息
     */
    @ResponseBody
    @RequestMapping(value = "/details",method = RequestMethod.GET)
    public Map getUserDetails(Long id) {
        if (id != null) {
            return ResultUtils.success(userService.queryUser(id));
        }
        return ResultUtils.error(ResultMsg.SYSTEM_INNER_ERROR.msg());
    }


    /**
     *  志愿者报名活动接口
     *
     * @author wanggang
     * @date 13:20 2018/12/27
     * @param activityUser 用户信息
     * @return 是否报名成功
     **/
    @ResponseBody
    @RequestMapping("/registrationactivities")
    public Map registrationActivities(ActivityUser activityUser) {
        if (ObjectUtil.isNotNull(activityUser) && activityUser.getActivityId() != null ) {
            //查询用户信息，判断用户是否是志愿者,去session中的用户id
            /*   */
            //1:为待审核状态
            activityUser.setActivityState(1);
            int count = activityUserService.registrationActivities(activityUser);
            if (count > 0) {
                return ResultUtils.success(ResultMsg.SUCCESS.msg());
            }
            return ResultUtils.error(ResultMsg.FAILED.msg());
        }
        return ResultUtils.error(ResultMsg.SYSTEM_INNER_ERROR.msg());
    }

}
