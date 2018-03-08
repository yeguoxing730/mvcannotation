package com.mvc4.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/17/16
 * Time: 8:48 AM
 * To change this template use File | Settings | File Templates.
 */

/**
 * 监听Session的创建与销毁
 *
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("Session 被创建");    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("ServletContex初始化");
    }
}
