package com.mvc4.web;

import com.mvc4.entity.DemoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/17/16
 * Time: 5:54 PM
 * To change this template use File | Settings | File Templates.
 * http://localhost:9090/spring-com.boot/redis/test
 */
@Controller
@RequestMapping("/redis")
public class RedisDemoInfoController {
    @Autowired
    com.mvc4.service.DemoInfoService demoInfoService;
    @RequestMapping("/test")
    public @ResponseBody
    String test(){
        DemoInfo loaded = demoInfoService.findById(1);
        System.out.println("loaded="+loaded);
        DemoInfo cached = demoInfoService.findById(1);
        System.out.println("cached="+cached);
        loaded = demoInfoService.findById(2);
        System.out.println("loaded2="+loaded);
        return"ok";
    }


    @RequestMapping("/delete")
    public@ResponseBody String delete(long id){
        demoInfoService.deleteFromCache(id);
        return"ok";
    }

    @RequestMapping("/test1")
    public@ResponseBody String test1(){
        demoInfoService.test();
        System.out.println("DemoInfoController.test1()");
        return"ok";
    }


    @RequestMapping("/templatetest")
    public @ResponseBody
    String templatetest(){
        DemoInfo loaded = demoInfoService.getDemoInfoById(1);
        System.out.println("loaded="+loaded);
        DemoInfo cached = demoInfoService.getDemoInfoById(1);
        System.out.println("cached="+cached);
        loaded = demoInfoService.findById(2);
        System.out.println("loaded2="+loaded);
        return"ok";
    }
}
