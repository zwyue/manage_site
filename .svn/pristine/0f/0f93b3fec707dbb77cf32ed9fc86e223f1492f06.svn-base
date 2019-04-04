package com.zr.gansu.dao;

import com.zr.gansu.domain.ThemeColor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ThemeColorMapper {

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