package com.mvc4.solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 7/5/16
 * Time: 10:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestSolrQuery {
    public static void main(String[] args) {
        TestSolrQuery testSolrQuery = new TestSolrQuery();
       // testSolrQuery.queryTop2();
        testSolrQuery.queryTop3();
    }

    public void queryTop2(){
        //实例化SolrServer，以获取与solrServer的通信
        SolrServer solrServer = new HttpSolrServer("http://localhost:8983/solr/solrNewCore");

        //创建查询参数以及设定的查询参数
        SolrQuery params = new SolrQuery();
        params.setRows(2);
        params.set("q", "*:*");

        //查询并获取相应的结果！
        QueryResponse response = null;
        try {
            response = solrServer.query(params);
        } catch (SolrServerException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            solrServer.shutdown();
        }

        //获取相关的查询结果
        if(response != null ){
            System.out.println("查询耗时（ms）：" + response.getQTime());
            System.out.println(response.toString());
        }


        //关闭SolrServer连接实例，释放资源
        solrServer.shutdown();
    }
    public void queryTop3(){
        //实例化SolrServer，以获取与solrServer的通信
        SolrServer solrServer = new HttpSolrServer("http://localhost:8983/solr/solrNewCore");

        //创建查询参数以及设定的查询参数
        SolrQuery params = new SolrQuery();
        params.setRows(3);
        params.set("q", "*:*");

        //查询并获取相应的结果！
        try {
            SolrDocumentList docs = solrServer.query(params).getResults();
            for (SolrDocument sd : docs) {
                System.out.println(sd.getFieldValue("id"));
                System.out.println(sd.getFieldValue("name"));
                System.out.println(sd.getFieldValue("price"));
                System.out.println("-----------");
            }

        } catch (SolrServerException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            solrServer.shutdown();
        }

        //关闭SolrServer连接实例，释放资源
        solrServer.shutdown();
    }
}
