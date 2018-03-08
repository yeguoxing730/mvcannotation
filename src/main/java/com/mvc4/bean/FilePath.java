package com.mvc4.bean;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/22/16
 * Time: 10:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class FilePath {
    final File appFolder = new File(System.getProperty("user.home"), ".yourapp");
    public static void main(String[] args){
       File file = new File("classpath:Application.class");

        System.out.println(FilePath.class.getResource("/"));
        System.out.println(FilePath.class.getClassLoader().getResource(""));
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
        System.out.println( file.getAbsoluteFile());
    }
}
