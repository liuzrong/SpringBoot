package com.critc.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.critc.controller.UserController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=MockServletContext.class)
@WebAppConfiguration
public class TestUser {
	private MockMvc mvc; 
	
	@Before 
	public void setUp() throws Exception { 
		
	} 
	
	
	
	
	
	
	
	
}
