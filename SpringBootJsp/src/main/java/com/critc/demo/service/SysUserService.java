package com.critc.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.critc.demo.dao.SysUserDao;
import com.critc.demo.model.SysUser;


@Service
public class SysUserService {
	
	@Autowired
    private SysUserDao sysUserDao;
		
	public SysUser getByUsername(String username) {
        return sysUserDao.getByUsername(username);
    }
	
}
