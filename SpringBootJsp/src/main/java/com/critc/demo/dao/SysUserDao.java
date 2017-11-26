package com.critc.demo.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.critc.demo.core.dao.BaseDao;
import com.critc.demo.model.SysUser;


@Repository
public class SysUserDao extends BaseDao<SysUser, SysUser>{
	
	Logger logger = LoggerFactory.getLogger(SysUserDao.class);

	public SysUser getByUsername(String username) {
        String sql = "select * from t_sys_user where username=?";
        logger.debug(sql);
        return get(sql, username);
    }
	
	  
}
