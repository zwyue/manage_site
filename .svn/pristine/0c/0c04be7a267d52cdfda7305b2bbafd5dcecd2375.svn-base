package com.zr.gansu.dao;

import com.zr.gansu.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *  用户dao
 *
 * @author wanggang
 * @date 13:48 2018/12/24
 **/
@Component
public interface UserMapper {

    /**
     *  根据主键删除用户信息
     *
     * @author wanggang
     * @date 13:49 2018/12/24
     * @param id 主键
     * @return 是否删除成功
     **/
    int deleteByPrimaryKey(Long id);

    /**
     * 添加用户信息
     *
     * @author wanggang
     * @date 13:49 2018/12/24
     * @param record 用户信息
     * @return 是否添加成功
     **/
    int insert(User record);

    /**
     * 添加用户信息
     *
     * @author wanggang
     * @date 13:49 2018/12/24
     * @param record 用户信息
     * @return 是否添加成功
     **/
    int insertSelective(User record);

    /**
     *  根据主键查询用户信息
     *
     * @author wanggang
     * @date 13:52 2018/12/24
     * @param id 主键
     * @return 用户信息
     **/
    User selectByPrimaryKey(Long id);

    /**
     * 用了锁的 根据主键查询用户信息
     *
     * @author WG
     * @date 2019/2/25 16:06
     * @param id 主键
     * @return 用户信息
     */
    User queryByPrimaryKey(Long id);

    /**
     *  根据主键更新课程的信息
     *
     * @author wanggang
     * @date 13:53 2018/12/24
     * @param record 用户信息
     * @return 是否更新成功
     **/
    int updateByPrimaryKeySelective(User record);

    /**
     *  根据主键更新课程的信息
     *
     * @author wanggang
     * @date 13:53 2018/12/24
     * @param record 用户信息
     * @return 是否更新成功
     **/
    int updateByPrimaryKey(User record);

    /**
     *  查询用户分页列表
     *
     * @author wanggang
     * @date 14:33 2018/12/26
     * @param  record 查询条件
     * @return 用户列表
     **/
    List<User> selectUser(User record);
}