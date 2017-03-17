package com.study.shopcar;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ShopcarApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ShopcarApplication.class).bannerMode(Mode.OFF).run(args);
	}
}
