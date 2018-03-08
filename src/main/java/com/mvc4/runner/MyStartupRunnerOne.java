package com.mvc4.runner;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/17/16
 * Time: 8:58 AM
 * To change this template use File | Settings | File Templates.
 */

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 实际应用中，我们会有在项目服务启动的时候就去加载一些数据或做一些事情这样的需求。
   为了解决这样的问题，Spring Boot 为我们提供了一个方法，通过实现接口 CommandLineRunner 来实现。
   很简单，只需要一个类就可以，无需其他配置。 和listerner的结果一样 做后台服务用
 Spring Boot应用程序在启动后，会遍历CommandLineRunner接口的实例并运行它们的run方法。
 也可以利用@Order注解（或者实现Order接口）来规定所有CommandLineRunner实例的运行顺序。
 */
@Component
public class MyStartupRunnerOne implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作1<<<<<<<<<<<<<");
    }
}
