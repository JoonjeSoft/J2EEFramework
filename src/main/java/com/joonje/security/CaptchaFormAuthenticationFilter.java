package com.joonje.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

public class CaptchaFormAuthenticationFilter extends FormAuthenticationFilter {
	public static final String DEFAULT_CAPTCHA_PARAM = "captcha";

	@Override
	protected boolean executeLogin(ServletRequest request, ServletResponse response)
			throws Exception {

		return super.executeLogin(request, response);
	}

	protected String getCaptcha(ServletRequest request) {
		return WebUtils.getCleanParam(request, DEFAULT_CAPTCHA_PARAM);
	}

	@Override
	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
		String username = getUsername(request);
		String password = getPassword(request);
		String captcha = getCaptcha(request);
		boolean rememberMe = isRememberMe(request);
		String host = getHost(request);
		return new UsernamePasswordCaptchaToken(username, password != null ? password.toCharArray() : null, rememberMe, host,
				captcha);

	}

}
