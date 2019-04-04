package com.zr.gansu.service.impl;

import com.zr.gansu.common.log.Log;
import com.zr.gansu.dao.ThemeColorMapper;
import com.zr.gansu.domain.ThemeColor;
import com.zr.gansu.service.ThemeColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yufei
 * @Description:
 * @Date: Create in 14:16 2018/12/20
 */
@Service
public class ThemeColorServiceImpl implements ThemeColorService {

    private final
    ThemeColorMapper themeColorMapper;

    @Autowired
    public ThemeColorServiceImpl(ThemeColorMapper themeColorMapper) {
        this.themeColorMapper = themeColorMapper;
    }


    @Override
    @Log
    public int deleteByPrimaryKey(Long id) {
        return themeColorMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Log
    public int insert(ThemeColor record) {
        return themeColorMapper.insert(record);
    }

    @Override
    @Log
    public List<ThemeColor> getThemeColorAll() {
        return themeColorMapper.getThemeColorAll();
    }

    @Override
    @Log
    public ThemeColor selectByPrimaryKey(Long id) {
        return themeColorMapper.selectByPrimaryKey(id);
    }

    @Override
    @Log
    public int updateByPrimaryKeySelective(ThemeColor record) {
        return themeColorMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public ThemeColor getThemeEnable() {
        return themeColorMapper.getThemeEnable();
    }
}
