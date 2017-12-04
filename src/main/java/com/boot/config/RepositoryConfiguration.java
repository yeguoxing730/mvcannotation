package com.boot.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/13/16
 * Time: 9:51 AM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.com.boot.entity"})
@EnableJpaRepositories(basePackages = {"com.com.boot.dao"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
