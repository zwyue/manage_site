package com.zr.gansu.dao;

import com.zr.gansu.common.auth.UserDetail;
import org.springframework.stereotype.Repository;

/**
 * @description: Auth 授权登录相关mapper
 * @author: KaiZhang
 * @create: 2019-02-26 16:09
 **/
@Repository
public interface AuthMapper {

    /**
     * 通过loginName查询用户信息
     * @param loginName 登录名
     * @return UserDetail
     */
    UserDetail getUserByLoginName(String loginName);


    /**
     * 赋予用户权限
     * @param userId userId
     * @param roleId roleId
     */
    Integer setUserRole(Long userId,Long roleId);


    /**
     * 新增用户
     * @param userDetail userDetail
     * @return Integer
     */
    Integer insertUser(UserDetail userDetail);


    /**
     * 通过用户Id查询用户信息
     * @param userId userId
     * @return UserDetail
     */
    UserDetail getUserById(Long userId);
}
