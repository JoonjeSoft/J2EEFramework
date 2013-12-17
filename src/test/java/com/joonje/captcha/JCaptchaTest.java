package com.joonje.captcha;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.octo.captcha.service.CaptchaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:E:/work/JAVA/MyEclipse/J2EEFramework/src/main/webapp/WEB-INF/jcaptcha_gmail.xml")
public class JCaptchaTest extends AbstractJUnit4SpringContextTests {
//	@Autowired
//	RandomWordGenerator wordgen;
	@Autowired
	CaptchaService captchaService;
	@Test
	public void test() throws Exception{
		BufferedImage image = (BufferedImage)captchaService.getChallengeForID("111");
		ImageIO.write(image, "jpg", new File("e:/abc.jpg"));
	}
}
