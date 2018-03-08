package com.mvc4.service;

import com.mvc4.entity.Demo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/12/16
 * Time: 3:24 PM
 * To change this template use File | Settings | File Templates.
 */
public interface DemoService {
    public void save(Demo demo);
    public Demo getById(long id);
    public List<Demo> likeName(String name);
}
