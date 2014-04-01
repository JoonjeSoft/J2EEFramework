package com.joonje.security;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.joonje.domain.User;
import com.joonje.service.UserService;
import com.octo.captcha.service.image.ImageCaptchaService;

public class MyJDBCRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;
	@Resource
	private ImageCaptchaService imageCaptchaService;

	public void setImageCaptchaService(ImageCaptchaService imageCaptchaService) {
		this.imageCaptchaService = imageCaptchaService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordCaptchaToken usernamePasswordToken = (UsernamePasswordCaptchaToken) token;
		String captcha = usernamePasswordToken.getCaptcha();
		String sessionId = (String) SecurityUtils.getSubject().getSession().getId();
		boolean isValidate = imageCaptchaService.validateResponseForID(sessionId, captcha);
		if (!isValidate) {
			throw new IncorrectCaptchaException("验证码不正确！");
		}
		String userName = usernamePasswordToken.getUsername();
		User user = userService.findUserByName(userName);
		if (user == null) {
			throw new UnknownAccountException("用户名不存在！");
		}
		String salt = "123";
		return new SimpleAuthenticationInfo(user.getName(), user.getPassword(), ByteSource.Util.bytes(salt), super.getName());
	}

}
