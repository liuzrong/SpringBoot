package com.critc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.critc.dao.SysUserDao;
import com.critc.model.SysUser;


@Service
public class SysUserService {
	
	@Autowired
    private SysUserDao sysUserDao;
		
	public SysUser getByUsername(String username) {
        return sysUserDao.getByUsername(username);
    }
	
	
	
}
