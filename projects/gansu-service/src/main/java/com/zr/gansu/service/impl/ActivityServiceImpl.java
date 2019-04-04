package com.zr.gansu.service.impl;

import com.zr.gansu.common.pageHelper.PagingQuery;
import com.zr.gansu.dao.ActivityMapper;
import com.zr.gansu.dao.ActivityTextMapper;
import com.zr.gansu.dao.ActivityUserMapper;
import com.zr.gansu.domain.Activity;
import com.zr.gansu.domain.ActivityText;
import com.zr.gansu.domain.ActivityUser;
import com.zr.gansu.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author WangGang
 * @description 活动接口实现类
 * @date 2018/12/26
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    final
    private ActivityMapper activityMapper;

    final
    private ActivityTextMapper activityTextMapper;

    final
    private ActivityUserMapper activityUserMapper;

    @Autowired
    public ActivityServiceImpl(ActivityMapper activityMapper, ActivityTextMapper activityTextMapper
            ,ActivityUserMapper activityUserMapper) {
        this.activityMapper = activityMapper;
        this.activityTextMapper = activityTextMapper;
        this.activityUserMapper = activityUserMapper;
    }

    /**
     *  活动删除成功
     *
     * @author wanggang
     * @date 11:40 2018/12/27
     * @param activity 删除条件
     * @return 是否删除成功
     **/
    @Override
    public int deleteActivity(Activity activity) {
        return activityMapper.updateByPrimaryKeySelective(activity);
    }

    /**
     *  管理员添加活动内容
     *
     * @author wanggang
     * @date 11:14 2018/12/28
     * @param activity 活动内容
     * @return 是否添加成功
     **/
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int addActivityContent(Activity activity, String contentText) {
        //1.先插入活动的内容 2.拿到插入数据的主键id 3.将数据插入活动表
        ActivityText activityText = new ActivityText();
        activityText.setContentText(contentText);
        activityTextMapper.insertSelective(activityText);
        //拿到,插入数据的主键id
        Long id = activityText.getId();
        if (id > 0) {
            activity.setContentId(id);
            return activityMapper.insertSelective(activity);
        }
        return 0;
    }

    @Override
    public ActivityUser queryActivityUser(Long activityId) {
        return activityUserMapper.selectActivityUser(activityId);
    }

    @Override
    @PagingQuery
    public List<Activity> queryActivity(Activity activity) {
        return activityMapper.queryActivity(activity);
    }

    @Override
    public Activity activitiesDetails(Long id) {
        return activityMapper.activitiesDetails(id);
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public int updateActivity(Activity activity) {
        //1.更新活动内容表 2.更新活动表内容
        ActivityText activityText = new ActivityText();
        activityText.setId(activity.getContentId());
        activityText.setContentText(activity.getContentText());
        if (activityTextMapper.updateByPrimaryKeySelective(activityText) > 0 ) {
            return activityMapper.updateByPrimaryKeySelective(activity);
        }
        return 0;
    }

}
