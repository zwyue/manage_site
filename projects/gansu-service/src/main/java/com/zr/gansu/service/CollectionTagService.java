package com.zr.gansu.service;

import com.zr.gansu.domain.CollectionTag;

import java.util.Map;

/**
 * @ClassName CollectionTagService
 * @Author Administrator
 * @Date 2019/2/20 15:59
 */
public interface CollectionTagService {
    /**
     * 通过id查找标签
     **/
    CollectionTag selectById(String s);

    /**
     * 新增标签
     **/
    Map insert(CollectionTag collectionTag);

    /**
     * 通过用户查找所有标签
     **/
    Map selectAllTagByUser(Long userId);
}
