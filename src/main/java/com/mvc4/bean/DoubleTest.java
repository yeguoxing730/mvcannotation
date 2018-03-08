package com.mvc4.bean;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/14/16
 * Time: 5:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class DoubleTest {
    public static void main(String[] args){
        String ex = "100000000";
        String ss = "10700.71";
        BigDecimal bigDecimal = new BigDecimal(ss);
        BigDecimal bigDecimal2 = new BigDecimal(ex);
        System.out.println(bigDecimal.multiply(bigDecimal2));
        double doubleVal = Double.valueOf(ss).doubleValue();
        System.out.println(((Double)(doubleVal * Long.valueOf(ex).longValue())));
        System.out.println(Double.valueOf(ss));
        System.out.println(Double.valueOf(ss).longValue());
    }

}
