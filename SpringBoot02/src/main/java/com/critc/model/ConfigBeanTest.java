package com.critc.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ConfigurationProperties(prefix="com.springboot")
@PropertySource("classpath:test.properties")
public class ConfigBeanTest {
	
	private String name;
	private String want;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWant() {
		return want;
	}
	public void setWant(String want) {
		this.want = want;
	}
	
	
	@Override
	public String toString() {
		return "ConfigBeanTest [name=" + name + ", want=" + want + "]";
	}
	
	
	

}
