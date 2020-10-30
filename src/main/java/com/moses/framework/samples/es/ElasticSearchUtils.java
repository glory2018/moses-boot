/*
 * Copyright © 2020 287664409@qq.com Inc. All rights reserved
 * @description: com.moses.framework.samples.es.ElasticSearchUtils
 * @version V1.0
 */
package com.moses.framework.samples.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.script.Script;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Moses
 * @date 2020/10/30
 */
public class ElasticSearchUtils {
    RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("127.0.0.1", Integer.parseInt("9200"), "http")));

    public static void main(String[] args) throws IOException {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("title", "My first blog entry");
        jsonMap.put("date", "2020/10/30");
        jsonMap.put("text", "Just trying this out...");
        ElasticSearchUtils es = new ElasticSearchUtils();
        es.index(jsonMap,"website","blog","123");
        es.getIndex("website", "123");
    }

    /**
     * 数据添加，主键自己定义
     *
     * @param jsonMap 要增加的数据
     * @param index   索引，类似数据库
     * @param type    类型，类似表
     * @param id      数据ID
     * @return
     */
    public void index(Map<String, Object> jsonMap, String index, String type, String id)  {
//        IndexRequest indexRequest = new IndexRequest("posts").id("1").source(jsonMap);
        IndexRequest indexRequest = new IndexRequest(index,type,id).source(jsonMap);
        try {
            IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 数据添加 主键uuid
     *
     * @param jsonMap 要增加的数据
     * @param index      索引，类似数据库
     * @param type       类型，类似表
     * @return
     */
    public  void index(Map<String, Object> jsonMap, String index, String type) {
         index(jsonMap, index, type, UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
    }
    public void getIndex(String index, String id) throws IOException {
        GetRequest getRequest = new GetRequest(index, id);
        GetResponse response = client.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(response.getSourceAsString());
        return;
    }

    public void delete(String index, String id) throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest(index, id);
        client.delete(deleteRequest, RequestOptions.DEFAULT);
    }

    //	# 修改也可以通过index存在则替换或者upsets
    public void update() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest("ttl", "doc", "1")
                .script(new Script("ctx._source.gender = \"male\""));
        client.update(updateRequest, RequestOptions.DEFAULT).getGetResult();
    }
}
