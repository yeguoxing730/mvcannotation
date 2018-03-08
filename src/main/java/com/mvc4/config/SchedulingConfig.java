package com.mvc4.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/8/16
 * Time: 6:37 PM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableScheduling
public class SchedulingConfig {
    @Scheduled(cron = "0/20 * * * * ?") // 每20秒执行一次
    public void scheduler() {
        System.out.println(">>>>>>>>> SchedulingConfig.scheduler()");
    }
}
