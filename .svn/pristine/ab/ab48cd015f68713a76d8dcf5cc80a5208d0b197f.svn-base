package com.zr.gansu.manage.controller;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.User;
import com.zr.gansu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @description: 用户Controller
 * @author: KaiZhang
 * @create: 2018-12-15 16:54
 **/
@RestController
@RequestMapping("/admin/user")
public class AdminUserController {

    final
    private UserService userService;

    @Autowired
    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    /**
     *  管理员审核是否成为志愿者
     *
     * @author wanggang
     * @date 15:20 2018/12/24
     * @param user 用户信息
     * @return 是否审核通过
     **/
    @ResponseBody
    @RequestMapping("/audit/volunteer")
    public Map auditVolunteer(User user) {
        if (ObjectUtil.isNotNull(user) && user.getId() != null && user.getVolunteerState() != null) {
            //判断用户是否申请成为志愿者
            if (!"2".equals(String.valueOf(user.getId()))) {
                return ResultUtils.error(ResultMsg.USERS_DID_NOT_APPLY_TO_BE_VOLUNTEERS.msg());
            }
            if (userService.volunteer(user) > 0) {
              return ResultUtils.success(ResultMsg.SUCCESS.msg());
            }
            return ResultUtils.error(ResultMsg.FAILED.msg());
        }
        return ResultUtils.error(ResultMsg.SYSTEM_INNER_ERROR.msg());
    }

    /**
     * @description  管理员查看申请成为志愿者列表
     * @author    Wg
     * @date     2018/12/26 11:07
     */
    @ResponseBody
    @RequestMapping("/user/list")
    public Map queryUser(@RequestParam(value="pageNum",defaultValue="1")Integer pageNum,
                         @RequestParam(value="pageSize",defaultValue="10")Integer pageSize) {
        //2:为申请成为志愿者的用户
        User user = new User();
        user.setVolunteerState(2);
        //分页参数，true代表统计count总数
        PageHelper.startPage(pageNum,pageSize,true);
        //获取课程列表
        List<User> list =  userService.selectUser(user);
        return ResultUtils.success(new PageInfo<>(list));
    }

}
