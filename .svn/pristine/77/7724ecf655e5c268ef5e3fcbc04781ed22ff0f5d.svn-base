package com.zr.gansu.service;

import com.zr.gansu.domain.Activity;
import com.zr.gansu.domain.ActivityUser;

import java.util.List;
import java.util.Map;

/**
 * @description  活动接口
 * @author    Wg
 * @date     2018/12/26 17:30
 */
public interface ActivityService {


    /**
     *  管路员是否删除成功
     *
     * @author wanggang
     * @date 11:30 2018/12/27
     * @param activity 条件
     * @return 是否删除成功
     **/
    int deleteActivity(Activity activity);

    /**
     *  添加活动内容
     *
     * @author wanggang
     * @date 10:42 2018/12/28
     * @param activity 活动内容
     * @return 是否添加成功
     **/
    int addActivityContent(Activity activity, String contentText);

    /**
     * 查询志愿者报名用户的信息
     *
     * @author WG
     * @date 2019/2/19 16:19
     * @param activityId 活动主键id
     * @return 报名的志愿者
     */
    ActivityUser queryActivityUser(Long activityId);

    /**
     *  查询活动列表
     *
     * @Author WG
     * @Date 16:08 2019/3/15 0015
     * @Param activity 查询条件
     * @return 活动List
     */
    List<Activity> queryActivity(Activity activity);

    /**
     * 根据id查询活动详情
     *
     * @Author WG
     * @Date 15:34 2019/3/18 0018
     * @Param id 主键
     * @return 活动详情
     */
    Activity activitiesDetails(Long id);

    /**
     * 修改活动
     *
     * @Author WG
     * @Date 16:51 2019/3/18 0018
     * @Param activity 更新信息
     * @return 是否更新成功
     */
    int updateActivity(Activity activity);

}
