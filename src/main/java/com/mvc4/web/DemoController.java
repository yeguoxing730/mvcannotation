package com.mvc4.web;

import com.alibaba.fastjson.JSONObject;
import com.mvc4.bean.DemoBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/8/16
 * Time: 6:09 PM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    /**
     * 返回demo数据:
     * 请求地址：http://localhost:9090/spring-com.boot/demo/getDemo
     * @return
     */
    @RequestMapping("/getDemo")
    public DemoBean getDemo(){
        DemoBean demo = new DemoBean();
        demo.setId(2);
        demo.setName("Angel");
        return demo;
    }

    /**
     *   http://127.0.0.1:8080/demo/getFastJson
     * @return
     */
    @RequestMapping("/getFastJson")
    public String getFastJson(){
        DemoBean demo = new DemoBean();
        demo.setId(2);
        demo.setName("Angel2");
        return JSONObject.toJSONString(demo);
    }
    /**
     * http://127.0.0.1:8080/demo/zeroException
     * @return
     */
    @RequestMapping("/zeroException")
    public int zeroException(){
        return 100/0;
    }
}
