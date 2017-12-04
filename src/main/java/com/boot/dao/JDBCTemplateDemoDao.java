package com.boot.dao;

import com.boot.entity.Demo;
import com.boot.entity.DemoInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/12/16
 * Time: 2:54 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class JDBCTemplateDemoDao {
    @Resource
    private org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;

    /**
     * 通过id获取demo对象.
     * @param id
     * @return
     * http://localhost:9090/spring-com.boot/dao/getById?id=1000
     */
    public Demo getById(long id){
        String sql = "select * from Demo where id=?";
        RowMapper<Demo> rowMapper = new BeanPropertyRowMapper<Demo>(Demo.class);
        return jdbcTemplate.queryForObject(sql, rowMapper,id);
    }
    public DemoInfo getDemoInfoById(long id){
        String sql = "select * from DemoInfo where id=?";
        RowMapper<DemoInfo> rowMapper = new BeanPropertyRowMapper<DemoInfo>(DemoInfo.class);
        return jdbcTemplate.queryForObject(sql, rowMapper,id);
    }

}
