package com.critc.model;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("testdb")
public class TestDbConnector implements DBConnector{

	public void configure() {
		 System.out.println("testdb");
	}

}
