package com.critc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.critc.model.DBConnector;

@RestController
@RequestMapping("/task")
public class TestConnector {

	@Autowired private DBConnector connector;
	
	@RequestMapping("/")
	public String hellTask(){
		connector.configure();
		return "hello";
	}
}
