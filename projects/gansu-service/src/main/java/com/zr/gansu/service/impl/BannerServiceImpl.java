package com.zr.gansu.service.impl;

import com.zr.gansu.common.log.Log;
import com.zr.gansu.dao.BannerMapper;
import com.zr.gansu.domain.Banner;
import com.zr.gansu.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yufei
 * @Description:banner图接口实现类
 * @Date: Create in 13:06 2018/12/24
 */
@Service
public class BannerServiceImpl implements BannerService {

    private final
    BannerMapper bannerMapper;

    @Autowired
    public BannerServiceImpl(BannerMapper bannerMapper) {
        this.bannerMapper = bannerMapper;
    }


    @Override
    @Log
    public int insert(Banner record) {
        return bannerMapper.insert(record);
    }

    @Override
    @Log
    public Banner selectByPrimaryKey(Long id) {
        return bannerMapper.selectByPrimaryKey(id);
    }

    @Override
    @Log
    public int updateByPrimaryKeySelective(Banner record) {
        return bannerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Log
    public List<Banner> getBannerBackList() {
        return bannerMapper.getBannerBackList();
    }

    @Override
    @Log
    public List<Banner> getBannerAll() {
        return bannerMapper.getBannerAll();
    }

    @Override
    @Log
    public int deleteBanner(Long id) {
        return bannerMapper.deleteBanner(id);
    }
}
