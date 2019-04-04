package com.zr.gansu.dao;

import com.zr.gansu.domain.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 通过用户id 查询角色
     * @param userId userId
     * @return role
     */
    Role findRoleByUserId(Long userId);
}