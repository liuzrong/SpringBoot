package com.critc.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.critc.demo.interceptor.MyInterceptor;



@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter{

	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/my/**").addResourceLocations("classpath:/my/");
	        super.addResourceHandlers(registry);
	    }
	    
	    @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/toLogin").setViewName("login");
	        super.addViewControllers(registry);
	    }
	    
	    
	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        // addPathPatterns 用于添加拦截规则
	        // excludePathPatterns 用户排除拦截
	        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/toLogin","/login");
	        super.addInterceptors(registry);
	    }
} 
