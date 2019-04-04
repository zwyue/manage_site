/**
 * 
 */
package com.zr.gansu.web.social.qq.connet;


import com.zr.gansu.web.social.qq.api.QQ;
import com.zr.gansu.web.social.qq.api.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 * @author zhailiang
 *
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

	private String appId;

	/**
	 * 获取code
	 */
	private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";

	/**
	 * 获取access_token 令牌
	 */
	private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";
	
	public QQServiceProvider(String appId, String appSecret) {
		// OAuth2Operations 有一个默认实现类，可以使用这个默认实现类
		// oauth2的一个流程服务
		super(new QQOAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
		this.appId = appId;
	}

	@Override
	public QQ getApi(String accessToken) {
		return new QQImpl(accessToken, appId);
	}

}
