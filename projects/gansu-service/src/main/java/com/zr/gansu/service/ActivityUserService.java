package com.zr.gansu.service;

import com.zr.gansu.domain.ActivityUser;

/**
 * @description  志愿者活动报名
 * @author    Wg
 * @date     2018/12/27 13:18
 */
public interface ActivityUserService {

    /**
     *  志愿者报名活动
     *
     * @author wanggang
     * @date 13:35 2018/12/27
     * @param activityUser 志愿者和活动主键
     * @return 是否报名成功
     **/
    int registrationActivities(ActivityUser activityUser);

    /**
     *  管理员审核志愿者是否可以参加活动
     *
     * @author wanggang
     * @date 14:33 2018/12/27
     * @param activityUser 活动和用户主键，审核是否通过
     * @return 是否操作成功
     **/
    int auditParticipateActivities(ActivityUser activityUser);
}
