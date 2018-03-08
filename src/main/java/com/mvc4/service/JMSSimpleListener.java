package com.mvc4.service;

import com.mvc4.bean.OrderBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 7/4/16
 * Time: 3:48 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class JMSSimpleListener {
    private final StoreService storeService;

    @Autowired
    public JMSSimpleListener(StoreService storeService) {
        this.storeService = storeService;
    }

    @JmsListener(destination = "simple.queue")
    public void receiveOrder(OrderBean order) {
        storeService.registerOrder(order);
    }
}
