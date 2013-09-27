package com.joonje.util.authcode;

import java.awt.image.BufferedImage;

public class LetterAuthCodeDecorator extends
		AuthCodeGenerator {
	private AuthCodeGenerator generator;
	public LetterAuthCodeDecorator(AuthCodeGenerator generator) {
		this.generator = generator;
	}
	@Override
	public BufferedImage generate() {
		BufferedImage image = generator.generate();
		return null;
	}

}
