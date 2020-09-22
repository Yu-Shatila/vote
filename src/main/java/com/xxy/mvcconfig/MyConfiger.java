package com.xxy.mvcconfig;

import com.xxy.interceptor.Magnetometer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Component
public class MyConfiger implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		Magnetometer mi = new Magnetometer();
		registry.addInterceptor(mi)
				.addPathPatterns("/**")
				.excludePathPatterns("/static/**");
	}
	
	

}
