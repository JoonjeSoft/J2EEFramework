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
	/**
	 * 是否启用
	 */
	private boolean enable = false;
	/**
	 * 表单提交验证码输入域参数名称
	 */
	private String captchaParam = "captcha";
	/**
	 * 验证码错误保存key
	 */
	private String failureKeyAttribute = "shiroLoginFailure";
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

	public String getFailureKeyAttribute() {
		return failureKeyAttribute;
	}

	public void setFailureKeyAttribute(String failureKeyAttribute) {
		this.failureKeyAttribute = failureKeyAttribute;
	}

	public ImageCaptchaService getImageCaptchaService() {
		return imageCaptchaService;
	}

	public void setImageCaptchaService(ImageCaptchaService imageCaptchaService) {
		this.imageCaptchaService = imageCaptchaService;
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
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

	/**
	 * 访问拒绝，在request中添加验证码错误提示信息
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		request.setAttribute(this.getFailureKeyAttribute(), "jCaptcha.error");
		return true;
	}

}
