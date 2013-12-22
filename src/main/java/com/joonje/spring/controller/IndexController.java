package com.joonje.spring.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joonje.model.User;
import com.octo.captcha.service.image.ImageCaptchaService;

@Controller
public class IndexController {

	@Resource
	private ImageCaptchaService imageCaptchaService;

	public ImageCaptchaService getImageCaptchaService() {
		return imageCaptchaService;
	}

	public void setImageCaptchaService(ImageCaptchaService imageCaptchaService) {
		this.imageCaptchaService = imageCaptchaService;
	}

	@RequestMapping(value = { "/index/add" }, method = RequestMethod.GET)
	@ResponseBody
	public User index() {
		User user = new User();
		user.setId("1");
		user.setName("安俊杰");
		user.setPassword("123456");
		return user;
	}

	@RequestMapping(value = { "/index/delete" }, method = RequestMethod.GET)
	@ResponseBody
	public String delete() {
		return "安俊杰";
	}

	@RequestMapping(value = { "/index/code" }, method = RequestMethod.GET)
	public void code(HttpServletRequest request, HttpServletResponse response) {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		// 指定生成的响应是图片
		response.setContentType("image/jpeg");
		BufferedImage image = imageCaptchaService.getImageChallengeForID(request.getSession()
				.getId());
		try {
			ImageIO.write(image, "JPEG", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
