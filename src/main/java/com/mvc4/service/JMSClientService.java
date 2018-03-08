package com.mvc4.service;

import com.mvc4.bean.OrderBean;

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
