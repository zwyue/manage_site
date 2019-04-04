package com.zr.gansu.service;

import com.zr.gansu.domain.User;

import java.util.List;
import java.util.Map;

/**
 *  用户接口
 *
 * @author wanggang
 * @date 10:17 2018/12/24
 **/
public interface UserService {

    /**
     *  申请成为志愿者
     *
     * @author wanggang
     * @date 10:28 2018/12/24
     * @param user 用户信息
     * @return 是否成功
     **/
    int volunteer(User user);

    /**
     *  根据主键查询用户信息
     *
     * @author wanggang
     * @date 17:52 2018/12/25
     * @param id 用户主键
     * @return 用户信息
     **/
    User queryUser(Long id);

    /**
     *  展示用户分页信息
     *
     * @author wanggang
     * @date 10:31 2018/12/26
     * @param user 用户信息
     * @return 返回用户分页列表
     **/
    List<User> selectUser(User user);

    /**
     *  用户申请成为志愿者
     *
     * @author wanggang
     * @date 17:50 2018/12/29
     * @param user 用户信息
     * @return 是否成功
     **/
    Map volunteerApplication(User user);
}
