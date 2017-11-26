package com.critc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.critc.service.SysUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SysUserTest {
	
	@Autowired
	private SysUserService sysUserService;
	
	@Test
	public void test1(){
		System.out.println(sysUserService.getByUsername("admin"));
	}

}
