package com.mvc4.web;

import com.mvc4.entity.Demo;
import com.mvc4.service.DemoService;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/12/16
 * Time: 2:30 PM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/dao")
public class DataBaseDemoController {
    @Resource
    private DemoService demoService;

    /**
     * 测试保存数据方法.
     * @return
     * use jpa
     */
    @RequestMapping("/save")
    public String save(){
        Demo d = new Demo("Angel");
        demoService.save(d);//保存数据.
        return"ok.Demo2Controller.save";
    }
    //地址：http://127.0.0.1:9090/spring-com.boot/dao/getById?id=1
    //use jdbc template
    @RequestMapping("/getById")
    public Demo getById(long id){
        return demoService.getById(id);
    }

    /**
     * use mybatis
     * @param name
     * @return  http://localhost:9090/spring-com.boot/dao/likeName?name=demotestusername
     */
    @RequestMapping("/likeName")
    public List<Demo> likeName(String name){
        return demoService.likeName(name);
    }

   // 分页查询测试

    /** PageHelper
     * 第一个参数是第几页；
       第二个参数是每页显示条数。
     * @param name
     * @return  http://localhost:9090/spring-com.boot/dao/likeNamePager?name=Angel
     */
    @RequestMapping("/likeNamePager")
    public List<Demo> likeNameUsingPager(String name){
        PageHelper.startPage(1, 1);
        return demoService.likeName(name);
    }

}
