package com.zr.gansu.dao;

import com.zr.gansu.domain.Activity;
import com.zr.gansu.domain.PopularActivity;
import com.zr.gansu.vo.PopularActivityVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description  热门活动mapper类
 * @author    Wg
 * @date     2018/12/27 9:59
 */
@Component
public interface PopularActivityMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PopularActivity record);

    int insertSelective(PopularActivity record);

    PopularActivity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PopularActivity record);

    List<PopularActivity> queryActivity(Long siteId);

    PopularActivityVo queryActivityById(long activityId);
}