package com.critc.model;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("devDB")
public class DevDbConnector implements DBConnector{

	public void configure() {
		System.out.println("devDb");
	}

}
