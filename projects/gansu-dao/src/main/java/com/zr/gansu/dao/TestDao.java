package com.zr.gansu.dao;

import org.springframework.stereotype.Component;

/**
 * @description: 测试dao
 * @author: KaiZhang
 * @create: 2018-12-18 10:18
 **/
@Component
public interface TestDao {
    String testQuery();

    Integer testAdd(String name);
}
