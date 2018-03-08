package com.mvc4.solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.Group;
import org.apache.solr.client.solrj.response.GroupCommand;
import org.apache.solr.client.solrj.response.GroupResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 7/5/16
 * Time: 10:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestSolrGroupQuery {
    public static void main(String[] args) {
        SolrServer solr = new HttpSolrServer("http://localhost:8983/solr/solrNewCore");

        // http://localhost:8983/solr/select?q=学生&group=true&group.field=age
        //ModifiableSolrParams params = new ModifiableSolrParams();
        SolrQuery params = new SolrQuery();

        //the common parameters for all search
        params.set("q", "*:*");
        params.set("fq", "age:[20 TO 30]", "grade:[70 TO *]"); // filter query
        params.set("fl", "*,score");  // field list
        params.set("sort", "grade desc" );  //default score desc.
        params.set("start", "0");
        params.set("rows", "10");
        params.set("timeAllowed", "30000"); //miliseconds
        //params.set("wt", "xml"); // the response writer type
        params.set("omitHeader", "true"); //default false
        params.set("cache", "false");     //default true

        //parameters only for grouping result
        params.set("group", "true");
        params.set("group.field", "id", "age");
        params.set("group.query", "学生", "学习", "grade:[0 TO 59.9]", "grade:[60 TO *]", "age:[10 TO 19]", "age:[20 TO *]" );
        //params.set("group.func", "grade GRATERTHAN 60"); // not found, don't use it!!!

        params.set("group.sort", "grade desc");
        params.set("group.format", "grouped"); //default:simple, other:grouped
        params.set("group.main", "false");    // when /*group.format=simple and */ group.main=true, just return the documentList only!!!

        params.set("group.ngroups", "true");
        params.set("group.truncate", "true"); //default is false;

        params.set("group.cache.percent", "50"); //default is 0;

        params.set("group.offset", "0");
        params.set("group.limit", "10");

        // 分布式设置
        //params.set("shards", "localhost:8983/solr1", "localhost:8983/solr2"); //shards=host:port/base_url[,host:port:/base_url,[....]]
        //params.set("shards.qt", "/select"); // qt: query type// to indicate the request Handler to use

        QueryResponse response = null;
        try {
            response = solr.query(params);
            //System.out.println("查询耗时：" + response.getQTime());
        } catch (SolrServerException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            solr.shutdown();
        }

        if (response != null) {
            GroupResponse groupResponse = response.getGroupResponse();

            if (groupResponse != null) {
                List<GroupCommand> groupCommandList = groupResponse.getValues();
                for (GroupCommand groupCommand : groupCommandList) {
                    System.out.println("GroupCommand Name : " + groupCommand.getName());
                    System.out.println("Num of Groups Found: " + groupCommand.getNGroups());
                    System.out.println("Num of documents Found: " + groupCommand.getMatches());

                    System.out.println("The groups are: ");
                    List<Group> groups = groupCommand.getValues();
                    for (Group group : groups) {
                        System.out.println("group value: " + group.getGroupValue());
                        SolrDocumentList solrDocumentList = group.getResult();
                        System.out.println("Num of Documents in this group: " + solrDocumentList.getNumFound());
                        System.out.println("start: " + solrDocumentList.getStart());
                        System.out.println("Max score: " + solrDocumentList.getMaxScore());
                        // solrDocumentList.get(index)

                        for (SolrDocument doc : solrDocumentList) {
                            System.out.println("the Fields of document:");
                            Collection<String> names = doc.getFieldNames();
                            for (String name : names) {
                                System.out.println(name + ": " + doc.getFieldValue(name));
                            }
                            System.out.println("\n");
                        }
                        System.out.println("\n\n");
                    }
                    System.out.println("\n\n");
                }
            }

            //System.out.println("response = " + response);
            //System.out.println(response.getStatus());
            System.out.println("查询耗时：" + response.getQTime());
        }


        solr.shutdown();
    }
}
