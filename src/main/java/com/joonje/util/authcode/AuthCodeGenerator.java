package com.joonje.util.authcode;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 验证码抽象生成器
 * 
 * @author Joonje
 * 
 */
public abstract class AuthCodeGenerator {
	protected BufferedImage bfImage;
	protected Graphics g;
	protected char[] authChar;
	protected Random random;
	protected int len;

	public abstract BufferedImage generate();

	protected BufferedImage getBfImage() {
		return bfImage;
	}

	public char[] getAuthChar() {
		return authChar;
	}

}
