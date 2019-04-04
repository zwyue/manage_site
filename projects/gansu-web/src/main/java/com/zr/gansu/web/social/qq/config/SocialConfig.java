/**
 *
 */
package com.zr.gansu.web.social.qq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.AuthenticationNameUserIdSource;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

/**
 * 社交登录配置主类
 *
 * @author zhailiang
 *
 */
@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private SecurityProperties securityProperties;

	@Autowired(required = false)
	private ConnectionSignUp connectionSignUp;
///
//	@Autowired(required = false)
//	private SocialAuthenticationFilterPostProcessor socialAuthenticationFilterPostProcessor;


	@Override
	public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
		JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource,
				connectionFactoryLocator, Encryptors.noOpText());
		// 指定表前缀，后缀是固定的，在JdbcUsersConnectionRepository所在位置
		repository.setTablePrefix("tbl_");
		if(connectionSignUp != null) {
			repository.setConnectionSignUp(connectionSignUp);
		}
		return repository;
	}

	@Override
	public UserIdSource getUserIdSource() {
		return new AuthenticationNameUserIdSource();
	}

	/**
	 * 社交登录配置类，供浏览器或app模块引入设计登录配置用。
	 * @return
	 */
	@Bean
	public SpringSocialConfigurer gansusocialsecurityconfig() {
//		// 默认配置类，进行组件的组装
//		// 包括了过滤器SocialAuthenticationFilter 添加到security过滤链中
/////		String filterProcessesUrl = securityProperties.getSocial().getFilterProcessesUrl();
//
////		String filterProcessesUrl = "/auth";
//
//
		GansuSpringSocialConfigurer configurer = new GansuSpringSocialConfigurer();
//
//
/////		configurer.signupUrl(securityProperties.getBrowser().getSignUpUrl());
////		configurer.setSocialAuthenticationFilterPostProcessor(socialAuthenticationFilterPostProcessor);
////		return configurer;
////		return new SpringSocialConfigurer();
		//这里自定义设置用户注册页面
//		configurer.signupUrl("/social/user");
		return configurer;
	}

//	@Bean
//	public SpringSocialConfigurer imoocSocialSecurityConfig(){
//		return new SpringSocialConfigurer();
//	}


	/**
	 * https://docs.spring.io/spring-social/docs/1.1.x-SNAPSHOT/reference/htmlsingle/#creating-connections-with-connectcontroller
	 * 注入connectController
	 * @param connectionFactoryLocator connectionFactoryLocator
	 * @param connectionRepository connectionRepository
	 * @return return
	 */
    @Bean
    public ConnectController connectController(ConnectionFactoryLocator connectionFactoryLocator,
                                               ConnectionRepository connectionRepository) {
        //        controller.setApplicationUrl(env.getRequiredProperty("application.url"));
        return new ConnectController(connectionFactoryLocator, connectionRepository);
    }


	/**
	 * 用来处理注册流程的工具类
	 *
	 * @param connectionFactoryLocator connectionFactoryLocator
	 * @return ProviderSignInUtils
	 */
	@Bean
	public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator connectionFactoryLocator) {
		return new ProviderSignInUtils(connectionFactoryLocator,
				getUsersConnectionRepository(connectionFactoryLocator)) {
		};
	}
}
