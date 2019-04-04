package com.zr.gansu.web.auth;

import com.zr.gansu.common.auth.UserDetail;
import com.zr.gansu.dao.AuthMapper;
import com.zr.gansu.dao.RoleMapper;
import com.zr.gansu.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

/**
 * @description: UserServiceImpl
 * @author: KaiZhang
 * @create: 2019-02-25 16:53
 **/
@Component("myUserDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService , SocialUserDetailsService {

    @Autowired
    AuthMapper authMapper;

    @Autowired
    RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        //获取用户进行校验,返回构造的UserDetails
        UserDetail userDetail = authMapper.getUserByLoginName(loginName);
        if(userDetail == null){
            throw new UsernameNotFoundException(String.format("No userDetail found with username '%s'.", loginName));
        }
        //获取用户权限
        Role role = roleMapper.findRoleByUserId(userDetail.getId());
        userDetail.setRole(role);
        return userDetail;
    }


    /**
     * 传进来的是SpringSocial根据社交网站用户openId查出来的用户的userId
     * @param userId userId
     * @return SocialUser
     * @throws UsernameNotFoundException UsernameNotFoundException
     */
    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        if(userId!=null){
            long id = Long.parseLong(userId);
            UserDetail userDetail = authMapper.getUserById(id);
            String password = userDetail.getPassword();
            Role role = roleMapper.findRoleByUserId(id);
            userDetail.setRole(role);
            return new SocialUser(userId,password,true,true,true,true,
                userDetail.getAuthorities());
        }
        throw new UsernameNotFoundException("用户找不到");
    }
}
