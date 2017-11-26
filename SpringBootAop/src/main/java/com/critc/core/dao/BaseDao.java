package com.critc.core.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

/**
 *  在切入点前的操作，按order的值由小到大执行
	在切入点后的操作，按order的值由大到小执行
 * @author liuzr
 *
 */
@Component
public class BaseDao<T, S> {
    @Autowired
    protected JdbcTemplate jdbcTemplate;
    
    @Autowired
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;


  
    
    protected int insert(String sql, T t) {
        return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(t));
    }

   
    protected int insertForId(String sql, T t, String pkField) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rc = namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(t), keyHolder, new String[]{pkField});
        if (rc > 0) {
            return keyHolder.getKey().intValue();
        } else {
            return 0;
        }
    }

    
    protected int update(String sql, T t) {
        return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(t));
    }

   
    protected int update(String sql, Object... objects) {
        return jdbcTemplate.update(sql, objects);
    }

   
    protected int delete(String sql, Object... objects) {
        return jdbcTemplate.update(sql, objects);
    }

   
    protected T get(String sql, Object... objects) {
        List<T> list = jdbcTemplate.query(sql, objects, BeanPropertyRowMapper.newInstance(getClazz()));
        if (list.size() > 0){
            return list.get(0);
        }
        else{
            return null;
        }
    }

    
    private Class<T> getClazz() {
        return ((Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]);
    }

  
    protected List<T> list(String sql) {
        List<T> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(getClazz()));
        return list;
    }

   
    protected List<T> list(String sql, Object... objects) {
        List<T> list = jdbcTemplate.query(sql, objects, BeanPropertyRowMapper.newInstance(getClazz()));
        return list;
    }

    
    protected List<T> list(String sql, S s) {
        List<T> list = namedParameterJdbcTemplate.query(sql, new BeanPropertySqlParameterSource(s), BeanPropertyRowMapper.newInstance(getClazz()));
        return list;
    }

    
    protected int count(String sql) {
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

   
    protected int count(String sql, Object... objects) {
        return jdbcTemplate.queryForObject(sql, objects, Integer.class);
    }

    
    protected int count(String sql, S s) {
        return namedParameterJdbcTemplate.queryForObject(sql, new BeanPropertySqlParameterSource(s), Integer.class);
    }

   

   

}
