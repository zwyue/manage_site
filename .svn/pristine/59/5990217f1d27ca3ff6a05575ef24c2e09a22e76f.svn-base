package com.zr.gansu.service.impl;

import com.zr.gansu.common.log.Log;
import com.zr.gansu.dao.OptionMapper;
import com.zr.gansu.domain.Option;
import com.zr.gansu.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: yufei
 * @Description:调查问卷问题选项接口实现类
 * @Date: Create in 18:28 2018/12/28
 */
@Service
public class OptionServiceImpl implements OptionService {

    private final
    OptionMapper optionMapper;

    @Autowired
    public OptionServiceImpl(OptionMapper optionMapper) {
        this.optionMapper = optionMapper;
    }

    @Override
    @Log
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Long questionnaireId) {
        return optionMapper.deleteByPrimaryKey(questionnaireId);
    }

    @Override
    @Log
    @Transactional(rollbackFor = Exception.class)
    public int updateIsDeleted(Long id) {
        return optionMapper.updateIsDeleted(id);
    }

    @Override
    @Log
    @Transactional(rollbackFor = Exception.class)
    public int insert(Option record) {
        return optionMapper.insert(record);
    }

    @Override
    @Log
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(Option record) {
        return optionMapper.updateByPrimaryKeySelective(record);
    }
}
