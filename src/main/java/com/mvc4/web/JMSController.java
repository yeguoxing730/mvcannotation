package com.mvc4.web;

import com.mvc4.bean.OrderBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/15/16
 * Time: 9:02 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/jms")
public class JMSController {
    @Autowired
    private com.mvc4.service.JMSClientService jmsClientService;

    @Autowired
    private com.mvc4.service.StoreService storeService;
    /**
     * 返回html模板.
     */
    @RequestMapping("/jmstest")
    public @ResponseBody
    String testJMS(){
        jmsClientService.addOrder(new OrderBean("order1"));
        Optional<OrderBean> storedOrder = storeService.getReceivedOrder("order1");
        //System.out.println(storedOrder.get());
        return "send message success";
    }
    @RequestMapping("/jmstest2")
    public @ResponseBody
    String testJMS2(){
        jmsClientService.addOrder(new OrderBean("order2"));
        Optional<OrderBean> storedOrder = storeService.getReceivedOrder("order2");
//        System.out.println(storedOrder.get());
        return "send message success";
    }
}
