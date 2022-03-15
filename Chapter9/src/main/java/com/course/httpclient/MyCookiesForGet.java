package com.course.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {

    private String url;
    private ResourceBundle bundle;
    private  CookieStore cookieStore;
    //声明一个客户端 用来执行方法
    private CloseableHttpClient client;

    //根据配置文件 获取url
    @BeforeTest
    public void getConfig(){
        bundle=ResourceBundle.getBundle("application", Locale.CHINA);
        url=bundle.getString("test.url");
    }

    //获取到cookies信息
    @Test
    public void getCookies() throws IOException {
        //获取uri
        String uri=bundle.getString("getCookies.uri");
        //拼接访问地址
        String testUrl1=this.url+uri;
        //声明http请求
        HttpGet get=new HttpGet(testUrl1);
        //获取cookies信息
        cookieStore = new BasicCookieStore();
        client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        //执行请求
        HttpResponse response= client.execute(get);
        //返回结果
        String result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //循环输出cookies的值
        List<Cookie> cookies=cookieStore.getCookies();
         for (Cookie cookie:cookies){
             String name=cookie.getName();
             String value=cookie.getValue();
             System.out.println("获取到的name=："+name+";    value="+value);
         }
    }

    //携带cookies信息访问get请求
    @Test(dependsOnMethods = "getCookies")
    public void getWithCookies() throws IOException {
        //获取uri
        String uri=bundle.getString("getWithCookies.uri");
        String testUrl2=this.url+uri;
        //声明http请求
        HttpGet get=new HttpGet(testUrl2);
        //执行请求
        client= HttpClientBuilder.create().setDefaultCookieStore(this.cookieStore).build();
        HttpResponse response=client.execute(get);
        //获取返回的状态码
        int statusCode=response.getStatusLine().getStatusCode();
        System.out.println("状态码是："+statusCode);
        if (statusCode==200){
            //返回结果
            String result=EntityUtils.toString(response.getEntity(),"utf-8");
            //输出结果
            System.out.println(result);
        }
    }
}
