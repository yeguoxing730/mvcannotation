package com.mvc4.config;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/21/16
 * Time: 9:11 AM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@MapperScan("com.com.boot.mapper")
public class MyBatisConfiguration {
    @Bean
    public com.github.pagehelper.PageHelper pageHelper() {
        System.out.println("MyBatisConfiguration.pageHelper()");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}
