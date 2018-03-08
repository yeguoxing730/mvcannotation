package com.mvc4.bean;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/13/16
 * Time: 3:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestBean {

    private LinkedList<String> linkedList = new LinkedList();
    private   Map<String, Integer> indexMap = new HashMap<String, Integer>();
    private List<String[]> histRight = new ArrayList<String[]>();

    public List<String[]> getHistRight() {
        return histRight;
    }

    public void setHistRight(List<String[]> histRight) {
        this.histRight = histRight;
    }

    public Map<String, Integer> getIndexMap() {
        return indexMap;
    }

    public void setIndexMap(Map<String, Integer> indexMap) {
        this.indexMap = indexMap;
    }

    public LinkedList<String> getLinkedList() {
        return linkedList;
    }

    public void setLinkedList(LinkedList<String> linkedList) {
        this.linkedList = linkedList;
    }


    public  static void  main(String[] args){

        TestBean testBean = new TestBean();
        testBean.getLinkedList().add(0,"a");
        testBean.getLinkedList().add(1,"b");
        testBean.getLinkedList().add(2,"c");
        testBean.getIndexMap().put("a",0);
        testBean.getIndexMap().put("b",1);
        testBean.getIndexMap().put("c",2);
        String[] str2 =   new String[]{"a", "c", "e"};
        String[] str3   = new String[]{"a", "d", "e","l","m","n"};
        String[] str4 =   new String[]{"a",  "k","n"};
        String[] str5 =   new String[]{"a",  "j","m"};
        String[] str6 =   new String[]{"a",  "j","k"};
        String[] str7 =   new String[]{"a",  "k","m"};
        String[] str8 =   new String[]{"a",  "k","l"};

//        String[] str9 = new String[]{"a",}
//        insertNewStr(indexMap,sourceArr,str1);
        List<String[]> histRight = new ArrayList<String[]>();

        insertNewStr(testBean,str2);
        testBean.getHistRight().add(str2);
        testBean.refreshBefore();

        System.out.println("-------------------------------"+Arrays.toString(str3));
        insertNewStr(testBean, str3);
        testBean.getHistRight().add(str3);
        testBean.refreshBefore();

        System.out.println("-------------------------------"+Arrays.toString(str4));
        insertNewStr(testBean,str4);
        testBean.getHistRight().add(str4);
        testBean.refreshBefore();

        System.out.println("-------------------------------"+Arrays.toString(str5));
        insertNewStr(testBean,str5);
        testBean.getHistRight().add(str5);
        testBean.refreshBefore();

        System.out.println("-------------------------------"+Arrays.toString(str6));
        insertNewStr(testBean,str6);
        testBean.getHistRight().add(str6);
        testBean.refreshBefore();

        System.out.println("-------------------------------"+Arrays.toString(str7));
        insertNewStr(testBean,str7);
        testBean.getHistRight().add(str7);
        testBean.refreshBefore();

        System.out.println("-------------------------------"+Arrays.toString(str8));
        insertNewStr(testBean, str8);
        testBean.getHistRight().add(str8);
        testBean.refreshBefore();

      //  System.out.println(indexMap);
    }

    public static void insertNewStr(TestBean testBean,String[] newStrArr){
        Map<String,Integer> indexMap = testBean.getIndexMap();
        LinkedList<String> linkedList = testBean.getLinkedList();
        for(int i=0;i<newStrArr.length;i++){
            String str = newStrArr[i];
            Integer strIndex = testBean.getIndexMap().get(str);
            if(strIndex == null){
                testBean.getIndexMap().put(str,testBean.getIndexMap().keySet().size());
                testBean.getLinkedList().add(str);
            }
        }
     //   System.out.println("newArr==="+indexMap);

        getTheStrArray(testBean, indexMap, linkedList, newStrArr);
    }

    public static void getTheStrArray(TestBean testBean,Map<String,Integer> indexMap,LinkedList<String> linkedList,String[] newStrArr){
       int[] indexArr = new int[]{};
       String prev = newStrArr[0];
       int prevIndex = indexMap.get(prev); //7
       boolean changed = false;
       for(int i=0;i<newStrArr.length;i++){
          String str = newStrArr[i];
          int strIndex = indexMap.get(str);    //5
          if(strIndex<prevIndex){
              System.out.println("linkedList before==="+linkedList.toString());
              System.out.println("indexMap before==="+indexMap);
              //get last element
              int preIndex = linkedList.indexOf(prev);
              linkedList.add(linkedList.indexOf(str),prev);
              linkedList.remove(preIndex + 1);
              indexMap = testBean.refreshMap(linkedList);
              testBean.setIndexMap(indexMap);
              System.out.println("linkedList end==="+linkedList.toString());
              System.out.println("indexMap end==="+indexMap);
              changed = true;
              break;
          }
          prev = str;
          prevIndex = strIndex;
       }
        if(changed){
            System.out.println("change....");
            getTheStrArray(testBean, indexMap, linkedList, newStrArr);
        }
     //   System.out.println("source" + linkedList.toString());
       // System.out.println(indexMap.toString());
    }

    public Map<String,Integer> refreshMap(LinkedList<String> linkedList){
               Map<String,Integer> map = new HashMap<String, Integer>();
               for(String str:linkedList){
                   map.put(str,linkedList.indexOf(str));
               }
        return map;
    }
    public void refreshBefore(){
           for(String[] arr:this.getHistRight()){
               insertNewStr(this,arr);
           }
           System.out.println("refresh------result----------"+this.getLinkedList().toString());
    }
    class Node{
        String key;
        String value;

        String getKey() {
            return key;
        }

        void setKey(String key) {
            this.key = key;
        }

        String getValue() {
            return value;
        }

        void setValue(String value) {
            this.value = value;
        }
//        public  Node[] getNodeForArr(String[] arrs){
//                Node
//                for(String str:arrs){
//                    Node node = new Node();
//                }
//        }
    }


}
