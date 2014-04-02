package com.joonje.spring.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.octo.captcha.service.image.ImageCaptchaService;
/**
 * @author Joonje An
 *
 */
@Controller
@RequestMapping(value="/login")
public class LoginController {
	@SuppressWarnings("unused")
	private final static Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Resource
	private ImageCaptchaService imageCaptchaService;

	public void setImageCaptchaService(ImageCaptchaService imageCaptchaService) {
		this.imageCaptchaService = imageCaptchaService;
	}
	@RequestMapping(method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName,HttpServletRequest req,Model model) {
		model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
		String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
        String errorKey = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
        	errorKey =  "user.login.error";
        } else if(AuthenticationException.class.getName().equals(exceptionClassName)) {
        	errorKey =  "user.login.error";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
        	errorKey =  "user.login.error";
        } else if("jCaptcha.error".equals(exceptionClassName)) {
        	errorKey = "user.login.captchaerror";
        } else if(exceptionClassName != null) {
        	errorKey = "user.login.othererror";
        }
        model.addAttribute("errorKey", errorKey);
		return "login";
	}
	/**
	 * 生成验证码图片
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = { "/captcha" }, method = RequestMethod.GET)
	public void code(HttpServletRequest request, HttpServletResponse response) {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		// 指定生成的响应是图片
		response.setContentType("image/jpeg");
		BufferedImage image = imageCaptchaService.getImageChallengeForID(request.getSession().getId());
		try {
			ImageIO.write(image, "JPEG", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
