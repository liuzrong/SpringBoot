package com.critc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.critc.model.ConfigBean;
import com.critc.model.ConfigBeanTest;

@RestController
public class UserController {
	
	@Autowired
	private ConfigBean configBean;
	
	@Autowired
	private ConfigBeanTest configBeanTest;
	
	
	
	@RequestMapping("/hello")
	public String hello(){
		return "hello,world2sfsdfs";
	}
	
	@RequestMapping("/test1")
	public String test1(){
		return configBean.getUser();
	}
	
	@RequestMapping("/test2")
	public String test2(){
		return configBeanTest.getName() + "," + configBeanTest.getWant();
	}
	
	
	
}
