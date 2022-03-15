package com.course.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {

    private String url;
    //读取配置文件
    private ResourceBundle bundle;
    //声明一个客户端用来执行方法
    private CloseableHttpClient client;
    //声明cookies对象
    private CookieStore cookieStore;

    //根据配置文件获取url
    @BeforeTest
    public void getUrl(){
        bundle=ResourceBundle.getBundle("application", Locale.CHINA);
        url=bundle.getString("test.url");
    }

    //获取cookies信息
    @Test
    public void getCookies() throws IOException {
        //获取具体uri 并拼接
        String uri=bundle.getString("getCookies.uri");
        String testUrl=this.url+uri;
        //声明请求方法
        HttpGet get=new HttpGet(testUrl);
        //获取cookies信息
        this.cookieStore=new BasicCookieStore();
        this.client=HttpClientBuilder.create().setDefaultCookieStore(this.cookieStore).build();
        System.out.println("testurl:"+testUrl);
        //执行请求
        HttpResponse response=client.execute(get);
        //获得结果
        String result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //循环输出cookies
        List<Cookie> cookies=cookieStore.getCookies();
        for (Cookie cookie:cookies){
            String name=cookie.getName();
            String value=cookie.getValue();
            System.out.println("name的值是："+name+"value的值是："+value);
        }
    }

    //携带cookies访问post请求
    @Test(dependsOnMethods = "getCookies")
    public void postWithCookies() throws IOException {
        //获取uri
        String uri=bundle.getString("postWithCookies.uri");
        String testUrl=url+uri;
        //声明http请求方法
        HttpPost post=new HttpPost(testUrl);
        //添加参数
        JSONObject param=new JSONObject();
        param.put("name","wangwu");
        param.put("pwd","20");
        //设置请求头信息 header
        post.setHeader("content-type","application/json");
        //将参数信息添加到方法中
        StringEntity entity=new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //设置cookies信息
        client=HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
        //执行post方法
        HttpResponse response=client.execute(post);
        //获取响应结果
        String result=EntityUtils.toString(response.getEntity());
        System.out.println("result:"+result);
        //处理结果 判断结果是否符合预期
        //将返回的结果转换成json对象
        JSONObject resultJson=new JSONObject(result);
        //返回具体结果值
        String text=resultJson.getString("text");
        System.out.println("text的值："+text);
        String status=resultJson.getString("status");
        //判断结果值是否符合预期
        Assert.assertEquals("200",status);
    }

}
