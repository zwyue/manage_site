package com.zr.gansu.service;

import com.zr.gansu.domain.CollectionDomain;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 课程收藏
 *
 * @author yuyi
 */
public interface CollectionService {

    /**
     * 添加 课程收藏
     *
     * @author yuyi
     *
     * @param userId 用户ID
     *
     * @param courseId 课程ID
     *
     * @return
     */
    Map joinCollection(Long userId, Long courseId);

    /**
     * 取消 课程收藏
     *
     * @author yuyi
     *
     * @param userId
     *
     * @param courseId
     *
     * @return
     */
    Map cancelCollection(Long userId, Long courseId);

    /**
     * 加入收藏
     **/
    Map addCollection(Long courseId, Long userId);

    /**
     * 查看用户的所有收藏
     **/
    Map selectAllCollect(Long userId);

    CollectionDomain selectByCourseIdAndUserId(Long courseId, Long userId);
}
