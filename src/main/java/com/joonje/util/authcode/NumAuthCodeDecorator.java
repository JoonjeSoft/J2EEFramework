package com.joonje.util.authcode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class NumAuthCodeDecorator extends AuthCodeGenerator{
	private AuthCodeGenerator generator;
	
	public NumAuthCodeDecorator(AuthCodeGenerator generator) {
		this.generator = generator;
		this.g = generator.g;
		this.bfImage = generator.bfImage;
	}
	
	@Override
	public BufferedImage generate() {
		generator.generate();
		Font mFont = new Font("楷体", Font.BOLD, 30);
		g.setFont(mFont);
		Random random = new Random();
		String sRand = "";
		int itmp = 0;
		for (int i = 0; i < 4; i++) {
			if (random.nextInt(2) == 1) {
				itmp = random.nextInt(26) + 65; // 生成A~Z的字母
			} else {
				itmp = random.nextInt(10) + 48; // 生成0~9的数字
			}
			char ctmp = (char) itmp;
			sRand += String.valueOf(ctmp);
			Color color = new Color(
					20 + random.nextInt(110),
					20 + random.nextInt(110),
					20 + random.nextInt(110));
			g.setColor(color);
			/**** 随机缩放文字并将文字旋转指定角度 **/
			// 将文字旋转指定角度
//			Graphics2D g2d_word = (Graphics2D) g;
//			AffineTransform trans = new AffineTransform();
//			trans.rotate(random.nextInt(45) * 3.14 / 180,
//					15 * i + 10, 7);
//			// 缩放文字
//			float scaleSize = random.nextFloat() + 0.8f;
//			if (scaleSize > 1.1f)
//				scaleSize = 1f;
//			trans.scale(scaleSize, scaleSize);
//			g2d_word.setTransform(trans);
			/************************/
//			g.drawString(String.valueOf(ctmp), 30 * i + 40,16);
			g.drawString(String.valueOf(ctmp), 30 * i,30);

		}
		String s = null;
		try {
			s = new String("安俊杰".getBytes("gbk"),"utf8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		g.drawString(s, 30 * 5,30);
		return bfImage;
	}

}
