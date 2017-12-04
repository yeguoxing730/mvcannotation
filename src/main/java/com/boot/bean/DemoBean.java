package com.boot.bean;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/8/16
 * Time: 6:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class DemoBean {
    private long id;//主键.
    private String name;//测试名称.
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
