package com.boot.filter;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/15/16
 * Time: 8:47 AM
 * To change this template use File | Settings | File Templates.
 */

/**
 * http://localhost:9090/spring-com.boot/druid/index.html
 *  admin2 123456
 * druid过滤器.
 * @author Administrator
 *
 */
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
        initParams={
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
        }
)
public class DruidStatFilter  extends WebStatFilter {
}
