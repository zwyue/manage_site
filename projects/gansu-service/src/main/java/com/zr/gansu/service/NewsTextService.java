package com.zr.gansu.service;

import com.zr.gansu.domain.NewsText;

import java.util.Map;

/**
 * @Author: yufei
 * @Description:新闻内容service接口
 * @Date: Create in 13:18 2018/12/24
 */
public interface NewsTextService {

    int insertSelective(NewsText record);

    NewsText selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(NewsText record);
}
