package com.zr.gansu.service;

import com.zr.gansu.domain.Banner;

import java.util.List;
import java.util.Map;

public interface BannerService {
    int insert(Banner record);

    Banner selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Banner record);

    /**
     * 查询后台banner图信息
     * @return banner 列表
     */
    List<Banner> getBannerBackList();

    /**
     * 查询前台banner图展示
     * @return banner列表
     */
    List<Banner> getBannerAll();

    /**
     * 删除banner图
     * @param id id
     * @return 影响行
     */
    int deleteBanner(Long id);

}
