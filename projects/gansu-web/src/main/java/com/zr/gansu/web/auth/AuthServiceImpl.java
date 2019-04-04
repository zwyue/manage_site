package com.zr.gansu.web.auth;

import com.zr.gansu.common.auth.*;
import com.zr.gansu.common.exception.CustomException;
import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.dao.AuthMapper;
import com.zr.gansu.dao.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @description: 授权登录相关ServiceImpl
 * @author: KaiZhang
 * @create: 2019-02-26 16:21
 **/
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthMapper authMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    @Autowired
    @Qualifier("myUserDetailsServiceImpl")
    UserDetailsService userDetailsService;

    @Override
    public Map login(String loginName, String password) {
        //用户验证
        final Authentication authentication = authenticate(loginName, password);
        //存储认证信息
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return ResultUtils.success(authentication.getPrincipal());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map register(UserDetail userDetail, HttpServletRequest request) {
        //获取传入的登录名
        final String loginName = userDetail.getLoginName();
        //若登录名已被使用,抛异常
        if(authMapper.getUserByLoginName(loginName)!=null) {
            return ResultUtils.error("用户已存在");
        }
        //初始化BCryptPasswordEncoder,对密码进行加密;生成最后使用日期
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userDetail.getPassword();
        userDetail.setPassword(encoder.encode(rawPassword));
        userDetail.setLastPasswordResetDate(new Date());
        //插入用户信息
        int insertUser = authMapper.insertUser(userDetail);
        //默认所有注册用户均为普通学生,插入用户-角色表
        int setUserRole = authMapper.setUserRole(userDetail.getId(), 1L);
        //第三方用户注册
        String userId = Long.toString(userDetail.getId());
        providerSignInUtils.doPostSignUp(userId,new ServletWebRequest(request));
        if(insertUser > 0 && setUserRole > 0){
            return ResultUtils.success("用户注册成功!");
        }else {
            return ResultUtils.error("用户注册失败!");
        }
    }


    private Authentication authenticate(String loginName, String password) {
        try {
            //该方法会去调用userDetailsService.loadUserByUsername()去验证用户名和密码，如果正确，则存储该用户名密码到“security 的 context中”
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginName, password));
        } catch (DisabledException | BadCredentialsException e) {
            throw new CustomException(ResultJson.failure(ResultCode.LOGIN_ERROR, e.getMessage()));
        }
    }
}
