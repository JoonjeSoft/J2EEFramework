package com.joonje.captcha;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;

import javax.imageio.ImageIO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.octo.captcha.engine.CaptchaEngine;
import com.octo.captcha.service.CaptchaService;
import com.octo.captcha.service.captchastore.CaptchaStore;
import com.octo.captcha.service.captchastore.FastHashMapCaptchaStore;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;

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
	@Test
	public void test1() throws Exception{
		CaptchaStore captchaStore =  new FastHashMapCaptchaStore();
		//CaptchaEngine captchaEngine = new HotmailEngine();
		DefaultManageableImageCaptchaService service = new DefaultManageableImageCaptchaService(captchaStore, null, 180, 100000, 75000);
		for(int i=0;i<20;i++){
			BufferedImage image = (BufferedImage)service.getChallengeForID(String.valueOf(i));
			ImageIO.write(image, "jpg", new File("e:/abcd"+i+".jpg"));
		}
	}
}
