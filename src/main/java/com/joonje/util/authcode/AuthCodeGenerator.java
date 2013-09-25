package com.joonje.util.authcode;

import java.awt.image.BufferedImage;
/**
 * 验证码抽象生成器
 * @author Joonje
 *
 */
public abstract class AuthCodeGenerator {
	
	public abstract BufferedImage generate();
}
