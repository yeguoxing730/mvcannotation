package com.boot.bean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/22/16
 * Time: 3:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class EquailTest {
    public static void main(String[] args){
        EquailTest equailTest = new EquailTest();
        equailTest.testComplie();
//        String originStr = "中国";
//        String changeStr = equailTest.change(originStr);
//        System.out.println(originStr.equals(changeStr));
//
//        String originStrTow = "中国  ";
//        String changeStr2 = equailTest.change(originStr);
//        System.out.println(originStrTow.equals(changeStr2));
//
//        String originStrThree = " 中国  ";
//        System.out.println(originStrThree.startsWith(" "));
//
//        String originStrFour = "　　地方政府债     ";
//        System.out.println(originStrFour.startsWith("　　"));
//        String originStrFive = "　　地方政府债     ";
//        System.out.println(originStrFour.startsWith("　"));
    }
    public String change(String cellValue){
        cellValue = cellValue.replace((char)12288, ' ');
        //注意要去处全角空格只能使用下面的： 即可实现。
        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher m = p.matcher(cellValue);
        cellValue = m.replaceAll("");
        return cellValue;
    }
    public void testComplie(){
        String keyWorld = "基金类*其中：商业银行理财产品";
        keyWorld = keyWorld.replace((char) 12288, ' ');
        //注意要去处全角空格只能使用下面的： 即可实现。
        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher m = p.matcher(keyWorld);
        keyWorld = m.replaceAll("").replaceAll("\\*", ";")+";";
        System.out.println(keyWorld);
    }
    public void testConatain(){
        String source = "3-01Bond Depository Balance(By Investor type)";
    }
}
