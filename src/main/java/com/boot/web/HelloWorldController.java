package com.boot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/8/16
 * Time: 6:02 PM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/hellworld")
public class HelloWorldController {
    @RequestMapping("/hello")
    public String greeting() {
        return "Hello World!";
    }

}
