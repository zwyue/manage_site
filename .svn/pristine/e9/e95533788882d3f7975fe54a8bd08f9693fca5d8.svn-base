package com.zr.gansu.dao;

import com.zr.gansu.domain.Catagory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CatagoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Catagory record);

    int insertSelective(Catagory record);

    Catagory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Catagory record);

    int updateByPrimaryKey(Catagory record);

    /**
     * 查询分类List
     *
     * @author WG
     * @date 2019/2/20 15:13
     * @return 分类List
     */
    List queryCatagoryList();

    /**
     * 查询该名称下分类数量
     *
     * @author WG
     * @date 2019/2/20 14:50
     * @param name 分类名称
     * @return 存在个数
     */
    int queryCatagoryExist(String name);
}