package com.joonje.util.authcode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AuthCodeGenerator g = new NumAuthCodeDecorator(new BasicAuthCodeGenerator());
		BufferedImage bi = g.generate();
		try {
			ImageIO.write(bi, "png", new File("e:/abc.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
