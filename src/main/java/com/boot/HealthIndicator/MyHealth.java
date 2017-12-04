package com.boot.HealthIndicator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/17/16
 * Time: 10:06 AM
 * To change this template use File | Settings | File Templates.
 */

/**
 * spring-com.boot-actuator模块提供了一个监控和管理生产环境的模块，可以使用http、jmx、ssh、telnet等拉管理和监控应用。审计（Auditing）、
 健康（health）、数据采集（metrics gathering）会自动加入到应用里面。
 可以检查的其他一些情况的健康信息。下面的HealthIndicators会被Spring Boot自动配置：

 DiskSpaceHealthIndicator     低磁盘空间检测
 DataSourceHealthIndicator  检查是否能从DataSource获取连接
 MongoHealthIndicator   检查一个Mongo数据库是否可用（up）
 RabbitHealthIndicator   检查一个Rabbit服务器是否可用（up）
 RedisHealthIndicator      检查一个Redis服务器是否可用（up）
 SolrHealthIndicator  检查一个Solr服务器是否可用（up）
 http://localhost:9090/spring-com.boot/health
 http://localhost:9090/spring-com.boot/trace
 http://localhost:9090/spring-com.boot/info
 */
@Component
public class MyHealth implements HealthIndicator {
    @Override
    public Health health() {
        int errorCode = 0; // perform some specific health check
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }
}
