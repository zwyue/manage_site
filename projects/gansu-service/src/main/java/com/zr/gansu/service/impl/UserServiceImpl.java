package com.zr.gansu.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.zr.gansu.common.utils.ResultMsg;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.dao.UserMapper;
import com.zr.gansu.domain.User;
import com.zr.gansu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author WangGang
 * @description 用户接口实现类
 * @date 2018/12/24
 */
@Service
public class UserServiceImpl implements UserService {

    final
    private UserMapper userMapper;


    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * @description  申请成为志愿者
     * @author    Wg
     * @date     2018/12/24 13:57
     */
    @Override
    public int volunteer(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * @description  根据主键查询用户信息
     * @author    Wg
     * @date     2018/12/25 18:23
     */
    @Override
    public User queryUser(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * @description 用户列表
     * @author    Wg
     * @date     2018/12/26 13:04
     */
    @Override
    public List<User> selectUser(User user) {
        return userMapper.selectUser(user);
    }

    /**
     *  用户审核成为志愿者
     *
     * @author wanggang
     * @date 14:57 2018/12/29
     * @param user 用户对象
     * @return  返回是否成功信息
     **/
    @Override
    public Map volunteerApplication(User user) {
        if(ObjectUtil.isNotNull(user) && ObjectUtil.isNotNull(user.getId())) {
            //判断用户是否已经申请或已经成为志愿者
            User userVolunteer = queryUser(user.getId());
            if (ObjectUtil.isNull(userVolunteer) ) {
                return ResultUtils.error(ResultMsg.SYSTEM_INNER_ERROR.msg());
            }
            //0表示不是志愿者，不等于0，就已经申请，或是志愿者了
            String volunteerState = "0";
            if (!volunteerState.equals(String.valueOf(userVolunteer.getVolunteerState()))) {
                return ResultUtils.error(ResultMsg.YOU_HAVE_APPLIED_TO_BE_A_VOLUNTEER.msg());
            }
            //2为待审核的状态
            user.setVolunteerState(2);
            //更新用户志愿者状态
            int count = volunteer(user);
            if (count > 0) {
                return ResultUtils.success(ResultMsg.SUCCESS.msg());
            }
            return ResultUtils.error(ResultMsg.FAILED.msg());
        }
        return ResultUtils.error(ResultMsg.SYSTEM_INNER_ERROR.msg());
    }
}
