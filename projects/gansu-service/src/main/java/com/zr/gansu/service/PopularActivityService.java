package com.zr.gansu.service;

import com.github.pagehelper.PageInfo;
import com.zr.gansu.domain.PopularActivity;
import com.zr.gansu.domain.PopularActivityText;
import com.zr.gansu.vo.PopularActivityVo;

/***
 * @Author wanglidong
 * @Description 热门活动接口
 * @Date 2019/2/12 14:57
 * @Param
 * @return
**/
public interface PopularActivityService {

    int addActivityText(PopularActivityText popularActivityText);
    int addActivity(PopularActivity popularActivity);

    PageInfo queryActivity(Integer pageNum,Integer pageSize,Long siteId);

    PopularActivityVo queryActivityVo(long activityId);

    int modifyActivityInfo(PopularActivity popularActivity, String contentText);

    int delActivityById(long activityId);

    /**
     * 更新活动浏览量
     * @param activityId
     * @return
     */
    boolean updateActivityCounts(long activityId);
}
