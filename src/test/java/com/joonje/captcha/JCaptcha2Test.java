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
@ContextConfiguration(locations = "file:C:/Users/Anjunjie/git/J2EEFramework/src/main/webapp/WEB-INF/jcaptcha2_0.xml")
public class JCaptcha2Test extends AbstractJUnit4SpringContextTests {
	@Autowired
	CaptchaService captchaService;
	@Test
	public void test() throws Exception{
		
		for(int i=0;i<20;i++){
			BufferedImage image = (BufferedImage)captchaService.getChallengeForID(String.valueOf(i));
			ImageIO.write(image, "jpg", new File("e:/abcd"+i+".jpg"));
		}
	}
}
