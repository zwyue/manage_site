package com.zr.gansu.service.impl;

import com.zr.gansu.common.log.Log;
import com.zr.gansu.dao.SiteMapper;
import com.zr.gansu.domain.Site;
import com.zr.gansu.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author: yufei
 * @Description:
 * @Date: Create in 10:38 2018/12/24
 */
@Service
public class SiteServiceImpl implements SiteService {

    private final
    SiteMapper siteMapper;

    @Autowired
    public SiteServiceImpl(SiteMapper siteMapper) {
        this.siteMapper = siteMapper;
    }


    @Override
    @Log
    public int deleteByPrimaryKey(Long id) {
        return siteMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Log
    public int insertSelective(Site record) {
        return siteMapper.insertSelective(record);
    }

    @Override
    @Log
    public Site selectByPrimaryKey(Long id) {
        return siteMapper.selectByPrimaryKey(id);
    }

    @Override
    @Log
    public int updateByPrimaryKeySelective(Site record) {
        return siteMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Log
    public List<Site> getSiteList() {
        return siteMapper.getSiteList();
    }

    @Override
    @Log
    public List<Map<Long,Integer>> countUsers() {
        return siteMapper.countUsers();
    }

    @Override
    @Log
    public List<Map<Long,Integer>> countCredits() {
        return siteMapper.countCredits();
    }
}
