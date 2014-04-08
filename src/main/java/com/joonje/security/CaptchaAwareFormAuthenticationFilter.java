package com.joonje.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * 过滤器之前有错误，说明验证码验证错误 {@link CaptchaFilter#onAccessDenied(ServletRequest, ServletResponse)}
 * @author Joonje
 *
 */
public class CaptchaAwareFormAuthenticationFilter extends FormAuthenticationFilter {

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		if(request.getAttribute(getFailureKeyAttribute()) != null) {
            return true;
        }
		return super.onAccessDenied(request, response);
	}
	
}
