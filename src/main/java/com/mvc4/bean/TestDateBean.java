package com.mvc4.bean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/16/16
 * Time: 4:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestDateBean {
    public  static void main(String[] args) throws ParseException {
           String reportDate = "2016-04";
        DateFormat df = new SimpleDateFormat("yyyy-MM");
        String year = reportDate.substring(0, 4);
        String month = reportDate.substring(5);
        Date date = (Date) df.parse(reportDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);



    }
}
