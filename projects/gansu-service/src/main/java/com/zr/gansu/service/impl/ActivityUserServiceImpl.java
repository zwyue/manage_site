package com.zr.gansu.service.impl;

import com.zr.gansu.dao.ActivityUserMapper;
import com.zr.gansu.domain.ActivityUser;
import com.zr.gansu.service.ActivityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WangGang
 * @description 志愿者报名活动实现类
 * @date 2018/12/27
 */
@Service
public class ActivityUserServiceImpl implements ActivityUserService {

    final
    private ActivityUserMapper activityUserMapper;

    @Autowired
    public ActivityUserServiceImpl(ActivityUserMapper activityUserMapper) {
        this.activityUserMapper = activityUserMapper;
    }

    /**
     *  志愿者报名活动
     *
     * @author wanggang
     * @date 13:28 2018/12/27
     * @param activityUser 志愿者和活动主键
     * @return 是否报名活动成功
     **/
    @Override
    public int registrationActivities(ActivityUser activityUser) {
        return activityUserMapper.insertSelective(activityUser);
    }

    /**
     *  管理员审核志愿者是否可以参加活动
     *
     * @author wanggang
     * @date 14:38 2018/12/27
     * @param activityUser 用户和活动信息，是否通过
     * @return 是否操作成功
     **/
    @Override
    public int auditParticipateActivities(ActivityUser activityUser) {
        return activityUserMapper.updateByPrimaryKeySelective(activityUser);
    }
}
