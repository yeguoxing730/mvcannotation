package com.boot.service;

import com.boot.bean.OrderBean;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/28/16
 * Time: 8:44 AM
 * To change this template use File | Settings | File Templates.
 */
public interface JMSClientService {
    public void addOrder(OrderBean order);
}
