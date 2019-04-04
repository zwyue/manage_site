package com.zr.gansu.dao;

import com.zr.gansu.domain.Site;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SiteMapper {

    int deleteByPrimaryKey(Long id);

    int insertSelective(Site record);

    Site selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Site record);

    /**
     * 查询子站列表
     * @return 子站列表
     */
    List<Site> getSiteList();

    /**
     * 查询子站用户数量
     * @return 用户数Map集合
     */
    List<Map<Long,Integer>> countUsers();

    /**
     * 查询子站的总学分
     * @return 总学分的Map集合
     */
    List<Map<Long,Integer>> countCredits();

}