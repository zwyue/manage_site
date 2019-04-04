/**
 * 
 */
package com.zr.gansu.web.social.qq.connet;


import com.zr.gansu.web.social.qq.api.QQ;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * @author zhailiang
 *
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

	/**
	 * 唯一的构造函数，需要
	 * Create a {@link OAuth2ConnectionFactory}.
	 * @param providerId 服务商id；自定义字符串；也是后面添加social的过滤，过滤器帮我们拦截的url其中的某一段地址
	 *                   on} interface.
	 */
	public QQConnectionFactory(String providerId, String appId, String appSecret) {
		// 传递进来是因为使用该服务的地方才知道  这些参数是什么
		/*
		 * serviceProvider 用于执行授权流和获取本机服务API实例的ServiceProvider模型
		 * apiAdapter      适配器，用于将不同服务提供商的个性化用户信息映射到 {@link Connection}
		 */
		super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
	}

}
