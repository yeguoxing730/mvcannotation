package com.boot.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/12/16
 * Time: 2:17 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * alter table demo change  id id  int not null  auto_increment;
 */
@Entity//加入这个注解，Demo就会进行持久化了，在这里没有对@Table进行配置，请自行配置。
@Table(name = "demo")
public class Demo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;//主键.
    @Column(nullable = false)
    private String name;//测试名称.
    public long getId() {
        return id;
    }
    public Demo(){}
    public Demo(String name) {
        this.name = name;
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
    @Override
    public String toString() {
        return getName() + "," + getId() ;
    }
}
