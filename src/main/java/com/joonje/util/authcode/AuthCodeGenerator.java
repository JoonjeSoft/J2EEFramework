package com.joonje.util.authcode;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
/**
 * 验证码抽象生成器
 * @author Joonje
 *
 */
public abstract class AuthCodeGenerator {
	protected BufferedImage bfImage;
	protected Graphics g;
	public abstract BufferedImage generate();
	protected BufferedImage getBfImage() {
		return bfImage;
	}
}
