/**
 * 
 */
package com.zr.gansu.web.social.qq.connet;


import com.zr.gansu.web.social.qq.api.QQ;
import com.zr.gansu.web.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @author zhailiang
 *
 */
public class QQAdapter implements ApiAdapter<QQ> {

	/**
	 * 确认qq是否是通的;测试服务是否可用
	 * @param api
	 * @return
	 */
	@Override
	public boolean test(QQ api) {
		return true;
	}

	/**
	 * 将connection所需的值设进去
	 * @param api
	 * @param values
	 */
	@Override
	public void setConnectionValues(QQ api, ConnectionValues values) {
		QQUserInfo userInfo = api.getUserInfo();
		values.setDisplayName(userInfo.getNickname());
		values.setImageUrl(userInfo.getFigureurl_qq_1());
		// 主页地址，像微博一般有主页地址
		values.setProfileUrl(null);
		// 服务提供商返回的该user的openid
		// 一般来说这个openid是和你的开发账户也就是appid绑定的
		//openId 唯一标识
		values.setProviderUserId(userInfo.getOpenId());
	}

	@Override
	public UserProfile fetchUserProfile(QQ api) {
		return null;
	}

	@Override
	public void updateStatus(QQ api, String message) {
		// 应该是退出的状态操作。
	}

}
