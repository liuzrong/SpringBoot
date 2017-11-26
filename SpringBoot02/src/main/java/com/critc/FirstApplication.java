package com.critc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RestController;

import com.critc.model.ConfigBean;



@RestController
@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class})
public class FirstApplication {

	
	/*@Value("value=${com.critc.name}")
	private String name;
	
	@RequestMapping("/")
	public String index(){
		System.out.println(name);
		return "Hello Spring Boot,"+name;
	}*/


	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);
	}
}
