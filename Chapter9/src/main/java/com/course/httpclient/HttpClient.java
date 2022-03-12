package com.course.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class HttpClient {
    @Test
    public void demo1() throws IOException {

        //声明http请求
        HttpGet httpGet=new HttpGet("https://www.nihaojewelry.com/");
        //打开客户端
        CloseableHttpClient client= HttpClients.createDefault();
        //执行请求
        HttpResponse response=client.execute(httpGet);
        //返回值
        System.out.println(EntityUtils.toString(response.getEntity()));

    }
}
