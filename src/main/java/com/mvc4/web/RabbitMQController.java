package com.mvc4.web;

import com.mvc4.message.Sender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/15/16
 * Time: 9:02 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/rabbitmq")
public class RabbitMQController {
    @Resource
    Sender sender;
    /**
     * 返回html模板.
     */
    @RequestMapping("/sendMsg")
    public @ResponseBody
    String sendMsg(){
       String msg = "message content";
        sender.sendMsg(msg);
        return "send message success";
    }

}
