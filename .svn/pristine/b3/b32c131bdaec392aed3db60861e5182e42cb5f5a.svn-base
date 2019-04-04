package com.zr.gansu.service.impl;

import com.zr.gansu.dao.TestDao;
import com.zr.gansu.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestServiceImpl implements TestService {

    final
    private TestDao testDao;

    @Autowired
    public TestServiceImpl(TestDao testDao) {
        this.testDao = testDao;
    }


    /**
     *  测试事务回滚
     *
     * @author WG
     * @date 2019/2/15 10:28
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addTest() {
        String str1 ="王五";
        testDao.testAdd(str1);
        int a = 1/0;
        String str2 = "li四";
        testDao.testAdd(str2);
        return 1;
    }
}
