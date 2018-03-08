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
public class Log4JListener implements ServletContextListener {
    public static final String log4jdirkey = "LOGDIR";
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String log4jdir = servletContextEvent.getServletContext().getInitParameter(log4jdirkey);
        System.setProperty(log4jdirkey, log4jdir);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.getProperties().remove(log4jdirkey);
    }
}
