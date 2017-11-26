package com.critc.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.critc.core.dao.BaseDao;
import com.critc.model.SysUser;


/**
 *  * @author liuzr
 *
 */
@Repository
public class SysUserDao extends BaseDao<SysUser, SysUser>{
	
	Logger logger = LoggerFactory.getLogger(SysUserDao.class);

	public SysUser getByUsername(String username) {
        String sql = "select * from t_sys_user where username=?";
        logger.debug(sql);
        
        return get(sql, username);
    }
	
	
	public int add(SysUser sysUser) {
        String sql = "insert into t_sys_user(id,username,password,randomcode,status,realname,mobile,created_at," +
                "created_by,role_id,department_id,pinyin,avatar,email,nation,gender,political,education," +
                "graduated_school,major,idcard,telephone,post,job_title,display_order,last_login_date)";
        sql += " values(seq_t_sys_user.nextval,:username,:password,:randomcode,1,:realname,:mobile,sysdate," +
                ":createdBy,:roleId,:departmentId,:pinyin,:avatar,:email,:nation,:gender,:political,:education," +
                ":graduatedSchool,:major,:idcard,:telephone,:post,:jobTitle,:displayOrder,:lastLoginDate)";
        return insertForId(sql, sysUser, "id");
    }
	  
}
