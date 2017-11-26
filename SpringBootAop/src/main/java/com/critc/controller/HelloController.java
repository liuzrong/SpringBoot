package com.critc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

	@RequestMapping("/hello")
	public String hello(String name){
		return "Hello,World:"+name;
	}
}
