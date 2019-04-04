package com.zr.gansu.service;

import com.zr.gansu.domain.Tag;

import java.util.List;

/**
 * @Author: yufei
 * @Description:
 * @Date: Create in 9:34 2018/12/24
 */
public interface TagService {

    int deleteByPrimaryKey(Long id);

    int insert(Tag record);

    Tag selectByPrimaryKey(Long id);

    /**
     * 修改标签信息
     * @param record record
     * @return  int
     */
    int updateByPrimaryKeySelective(Tag record);

    /**
     * 查询出所有的新闻标签
     * @return 标签列表
     */
    List<Tag> getTagList();
}
