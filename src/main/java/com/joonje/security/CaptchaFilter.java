package com.joonje.security;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import com.octo.captcha.service.image.ImageCaptchaService;

/**
 * 验证码过滤器
 * 
 * @author Joonje
 * 
 */
public class CaptchaFilter extends AccessControlFilter {
	private boolean enable = false;
	private String captchaParam = "captcha";
	private String errorKey = "captchaError";
	@Resource
	private ImageCaptchaService imageCaptchaService;

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getCaptchaParam() {
		return captchaParam;
	}

	public void setCaptchaParam(String captchaParam) {
		this.captchaParam = captchaParam;
	}

	public String getErrorKey() {
		return errorKey;
	}

	public void setErrorKey(String errorKey) {
		this.errorKey = errorKey;
	}

	public ImageCaptchaService getImageCaptchaService() {
		return imageCaptchaService;
	}

	public void setImageCaptchaService(ImageCaptchaService imageCaptchaService) {
		this.imageCaptchaService = imageCaptchaService;
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response,
			Object mappedValue) throws Exception {
		request.setAttribute("jcaptchaEbabled", enable);
		HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
		String requestMethod = httpServletRequest.getMethod();
		if (!this.enable || !"post".equalsIgnoreCase(requestMethod)) {
			return true;
		} else {
			String captcha = httpServletRequest.getParameter(captchaParam);
			String sessionId = httpServletRequest.getSession().getId();
			boolean validateResult = imageCaptchaService.validateResponseForID(sessionId, captcha);
			return validateResult;
		}
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
			throws Exception {
		request.setAttribute(this.errorKey, "jCaptcha.error");
		return false;
	}

}
