package com.zr.gansu.service.impl;

import com.zr.gansu.common.log.Log;
import com.zr.gansu.dao.NewsMapper;
import com.zr.gansu.dao.NewsTextMapper;
import com.zr.gansu.domain.NewsText;
import com.zr.gansu.service.NewsTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @Author: yufei
 * @Description:新闻内容的相关操作
 * @Date: Create in 13:18 2018/12/24
 */
@Service
public class NewsTextServiceImpl implements NewsTextService {

    @Autowired
    NewsTextMapper newsTextMapper;


    @Override
    public int insertSelective(NewsText record) {
        return newsTextMapper.insertSelective(record);
    }

    @Override
    public NewsText selectByPrimaryKey(Long id) {
        return newsTextMapper.selectByPrimaryKey(id);
    }


    @Override
    @Log
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(NewsText record) {
        return newsTextMapper.updateByPrimaryKeySelective(record);
    }
}
