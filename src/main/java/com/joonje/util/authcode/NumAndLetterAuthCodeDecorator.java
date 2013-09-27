package com.joonje.util.authcode;

import java.awt.image.BufferedImage;

public class NumAndLetterAuthCodeDecorator extends AuthCodeGenerator {
	private AuthCodeGenerator generator;
	public NumAndLetterAuthCodeDecorator(AuthCodeGenerator generator) {
		this.generator = generator;
	}
	@Override
	public BufferedImage generate() {
		generator.generate();
		return null;
	}

}
