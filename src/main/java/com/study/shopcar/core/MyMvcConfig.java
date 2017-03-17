package com.study.shopcar.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.study.shopcar.web.interceptor.AdminInterceptor;
import com.study.shopcar.web.interceptor.OriginInterceptor;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new OriginInterceptor()).addPathPatterns("/**");
		registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin/**");
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUseSuffixPatternMatch(false);
	}
}
