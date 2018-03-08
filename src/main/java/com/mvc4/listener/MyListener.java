package com.mvc4.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/17/16
 * Time: 8:42 AM
 * To change this template use File | Settings | File Templates.
 */
@WebListener
public class MyListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("servelt container init (listener).....");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("servelt container destroy (listener).....");
    }
}
