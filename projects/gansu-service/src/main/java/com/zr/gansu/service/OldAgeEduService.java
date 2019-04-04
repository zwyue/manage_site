package com.zr.gansu.service;

import com.github.pagehelper.PageInfo;
import com.zr.gansu.domain.OldAgeActivity;
import com.zr.gansu.domain.OldAgeActivityText;
import com.zr.gansu.form.OldAgeActivityForm;

import java.util.Map;

/**
 * 老年活动相关 service
 *
 * @author yuyi
 */
public interface OldAgeEduService {
    /**
     * 添加老年活动
     *
     * @author yuyi
     *
     * @param oldAgeActivityForm 添加活动相关参数
     *
     *
     */
    void addOldAgeActivity(OldAgeActivityForm oldAgeActivityForm);

    /**
     * 修改老年活动
     *
     * @author yuyi
     *
     * @param oldAgeActivityForm
     */
    void modifyOldAgeActivity(OldAgeActivityForm oldAgeActivityForm);

    /**
     * 删除老年活动
     *
     * @author yuyi
     *
     * @param id 主键
     */
    void deleteOldAgeActivity(Long id);

    /**
     * 分页查询
     *
     * @author yuyi
     *
     * @param type
     *
     * @param page
     *
     * @param size
     *
     * @return
     */
    PageInfo findByPagination(Integer type,Integer page, Integer size);

    /**
     * 根据ID查询活动详情
     *
     * @author yuyi
     *
     * @param id 活动表主键
     *
     * @return
     */
    OldAgeActivity findByActivityId(Long id);

    /**
     * 根据ID查询活动内容详情
     *
     * @author yuyi
     *
     * @param id 内容表主键
     *
     * @return
     */
    OldAgeActivityText findByContentId(Long id);

    /**
     * 活动或课程报名
     *
     * @author yuyi
     *
     * @param id 主键
     *
     * @return
     */
    Map signUp(Long id);

    /**
     * 活动课程取消报名
     *
     * @author yuyi
     *
     * @param id 主键
     *
     * @return
     */
    Map signOut(Long id);

    /**
     * 活动课程是否已参加
     *
     * @param id 主键
     *
     * @return
     */
    Map isJoin(Long id);

    /**
     * 查询已参加的活动或课程
     *
     * @param type
     *
     * @param page
     *
     * @param size
     *
     * @return
     */
    PageInfo findByPaginationWithJoin(Integer type, Integer page, Integer size);

    /**
     * 签到
     *
     * @param id
     *
     * @return
     */
    Map checkIn(Long id);

    /**
     * 签退
     *
     * @param id
     *
     * @return
     */
    Map signOff(Long id);
}
