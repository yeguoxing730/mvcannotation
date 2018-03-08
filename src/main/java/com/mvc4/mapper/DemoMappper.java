package com.mvc4.mapper;

import com.mvc4.entity.Demo;
import org.apache.ibatis.annotations.Select;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/21/16
 * Time: 9:14 AM
 * To change this template use File | Settings | File Templates.
 */
public interface DemoMappper {
    @Select("select *from Demo where name = #{name}")
    public java.util.List<Demo> likeName(String name);

    @Select("select * from Demo where id = #{id}")
    public Demo getById(long id);

    @Select("select name from Demo where id = #{id}")
    public String getNameById(long id);
}
