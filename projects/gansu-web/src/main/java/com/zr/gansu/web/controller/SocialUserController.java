package com.zr.gansu.web.controller;

import com.zr.gansu.common.utils.ResultUtils;
import com.zr.gansu.domain.SocialUserInfo;
import com.zr.gansu.web.security.SimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.DisconnectInterceptor;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @description: 社交登录用户Controller
 * @author: KaiZhang
 * @create: 2019-03-04 17:25
 **/
@RestController
public class SocialUserController {

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    @Autowired
    private ConnectionFactoryLocator connectionFactoryLocator;

    @Autowired
    private ConnectionRepository connectionRepository;

    private final MultiValueMap<Class<?>, DisconnectInterceptor<?>> disconnectInterceptors = new LinkedMultiValueMap<Class<?>, DisconnectInterceptor<?>>();

    /**
     * 获取当前社交登录的用户信息
     * @param request request
     * @return return
     */
    @PostMapping("/social/user")
    @ResponseBody
    public Map getSocialUserInfo(HttpServletRequest request){
        SocialUserInfo userInfo = new SocialUserInfo();
        Connection<?> connection = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
        userInfo.setProviderId(connection.getKey().getProviderId());
        userInfo.setProviderUserId(connection.getKey().getProviderUserId());
        userInfo.setNickName(connection.getDisplayName());
        userInfo.setHeadImg(connection.getImageUrl());
        return ResultUtils.success(userInfo);
    }

    /**
     * 解除绑定
     * @param providerId providerId
     * @param request request
     * @return return
     */
    @RequestMapping(value="/connect/ajax/{providerId}", method= RequestMethod.DELETE)
    public SimpleResponse removeConnections(@PathVariable String providerId, NativeWebRequest request) {
        ConnectionFactory<?> connectionFactory = connectionFactoryLocator.getConnectionFactory(providerId);
        preDisconnect(connectionFactory, request);
        connectionRepository.removeConnections(providerId);
        postDisconnect(connectionFactory, request);
        return new SimpleResponse("解除绑定成功");
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void preDisconnect(ConnectionFactory<?> connectionFactory, WebRequest request) {
        for (DisconnectInterceptor interceptor : interceptingDisconnectionsTo(connectionFactory)) {
            interceptor.preDisconnect(connectionFactory, request);
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void postDisconnect(ConnectionFactory<?> connectionFactory, WebRequest request) {
        for (DisconnectInterceptor interceptor : interceptingDisconnectionsTo(connectionFactory)) {
            interceptor.postDisconnect(connectionFactory, request);
        }
    }

    private List<DisconnectInterceptor<?>> interceptingDisconnectionsTo(ConnectionFactory<?> connectionFactory) {
        Class<?> serviceType = GenericTypeResolver.resolveTypeArgument(connectionFactory.getClass(), ConnectionFactory.class);
        List<DisconnectInterceptor<?>> typedInterceptors = disconnectInterceptors.get(serviceType);
        if (typedInterceptors == null) {
            typedInterceptors = Collections.emptyList();
        }
        return typedInterceptors;
    }
}
