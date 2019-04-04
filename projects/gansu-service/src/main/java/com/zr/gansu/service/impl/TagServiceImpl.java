package com.zr.gansu.service.impl;

import com.zr.gansu.common.log.Log;
import com.zr.gansu.dao.TagMapper;
import com.zr.gansu.domain.News;
import com.zr.gansu.domain.Tag;
import com.zr.gansu.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: yufei
 * @Description:新闻所属标签的tag信息操作
 * @Date: Create in 9:35 2018/12/24
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;

    /**
     * 根据主键id删除tag分类
     * @param id
     * @return
     */
    @Override
    @Log
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Long id) {
        return tagMapper.deleteByPrimaryKey(id);
    }

    /**
     * 新增tag标签
     * @param record
     * @return
     */
    @Override
    @Log
    @Transactional(rollbackFor = Exception.class)
    public int insert(Tag record) {
        return tagMapper.insert(record);
    }

    /**
     * 查询tag标签
     * @param id
     * @return
     */
    @Override
    @Log
    public Tag selectByPrimaryKey(Long id) {
        return tagMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新tag标签
     * @param record
     * @return
     */
    @Override
    @Log
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(Tag record) {
        return tagMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Log
    public List<Tag> getTagList() {
        return tagMapper.getTagList();
    }


}
