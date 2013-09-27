package com.joonje.util.authcode;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class BasicAuthCodeGenerator extends
		AuthCodeGenerator {
	private int width = 200;
	private int height = 60;
	public BasicAuthCodeGenerator() {
		BufferedImage image = new BufferedImage(width,
				height, BufferedImage.TYPE_INT_RGB); // 创建BufferedImage类的对象
		Graphics g = image.getGraphics();
		this.bfImage = image;
		this.g = g;
	}

	@Override
	public BufferedImage generate() {
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);
		return bfImage;
	}

	public Color getRandColor(int s, int e) {
		Random random = new Random();
		if (s > 255)
			s = 255;
		if (e > 255)
			e = 255;
		int r = s + random.nextInt(e - s);
		int g = s + random.nextInt(e - s);
		int b = s + random.nextInt(e - s);
		return new Color(r, g, b);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
