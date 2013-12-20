package com.joonje.captcha;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.octo.captcha.engine.CaptchaEngine;
import com.octo.captcha.service.multitype.GenericManageableCaptchaService;

public class EngineTest {

	@Test
	public void test() throws Exception {
		CaptchaEngine captchaEngine = new com.octo.captcha.engine.image.gimpy.DeformedBaffleListGimpyEngine();
		GenericManageableCaptchaService service = new GenericManageableCaptchaService(captchaEngine, 180, 180000, 75000);
		BufferedImage image = (BufferedImage) service.getChallengeForID("111");
		ImageIO.write(image, "jpg", new File("e:/abc.jpg"));
	}
}
