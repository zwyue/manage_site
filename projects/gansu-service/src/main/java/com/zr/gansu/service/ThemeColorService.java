package com.zr.gansu.service;


import com.zr.gansu.domain.ThemeColor;

import java.util.List;

/**
 * @Author: yufei
 * @Description:主题颜色的Service
 * @Date: Create in 14:15 2018/12/20
 */

public interface ThemeColorService {

    int deleteByPrimaryKey(Long id);

    int insert(ThemeColor record);

    List<ThemeColor> getThemeColorAll();

    ThemeColor selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ThemeColor record);

    /**
     * 查询前台展示的主题
     * @return 主题信息
     */
    ThemeColor getThemeEnable();

}
