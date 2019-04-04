package com.zr.gansu.dao;

import com.zr.gansu.domain.Activity;
import com.zr.gansu.domain.ActivityUser;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description  活动mapper类
 * @author    Wg
 * @date     2018/12/27 9:59
 */
@Component
public interface ActivityMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKeyWithBLOBs(Activity record);

    int updateByPrimaryKey(Activity record);

    /**
     *  查询活动List
     *
     * @Author WG
     * @Date 16:27 2019/3/15 0015
     * @Param activity 查询条件
     * @return 活动列表
     */
    List<Activity> queryActivity(Activity activity);

    /**
     * 根据id查询活动详情
     *
     * @Author WG
     * @Date 15:51 2019/3/18 0018
     * @Param activity
     * @return 活动信息
     */
    Activity activitiesDetails(Long id);

}