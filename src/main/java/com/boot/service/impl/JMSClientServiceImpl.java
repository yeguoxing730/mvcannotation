package com.boot.service.impl;

import com.boot.bean.OrderBean;
import com.boot.service.JMSClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/27/16
 * Time: 5:57 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class JMSClientServiceImpl implements JMSClientService {
    private static final String SIMPLE_QUEUE = "simple.queue";
    private final JmsTemplate jmsTemplate;

    @Autowired
    public JMSClientServiceImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
    @Override
    public void addOrder(OrderBean order) {
        jmsTemplate.convertAndSend(SIMPLE_QUEUE, order);
    }

}
