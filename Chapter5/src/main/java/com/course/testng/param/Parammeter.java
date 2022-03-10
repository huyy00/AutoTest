package com.course.testng.param;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class Parammeter {

    //xml参数化
    @Test
    @Parameters({"name1","pwd1"})
    public void login(String name,String pwd){
        System.out.println("xml参数化 name="+name+";   pwd="+pwd);
    }


    @Test(dataProvider = "loginOnData")
    public void login1(String name,String pwd){
        System.out.println("dataProvider参数化  name="+name+";   pwd="+pwd);
    }


    @DataProvider(name = "loginOnData")
    public Object[][] dataProvider(){
        Object[][] o=new Object[][]{
                {"lisi","123123"},
                {"wangwu","456456"}
        };
        return o;
    }

    //dataProvider 参数化
    @Test(dataProvider = "methon")
    public void register1(String name,String pwd){
        System.out.println("注册账号："+name+";密码："+pwd);
    }

    @Test(dataProvider = "methon")
    public void login3(String name,String pwd){
        System.out.println("登录账号："+name+";密码："+pwd);
    }

    @DataProvider(name = "methon")
    public Object[][] methonOnData(Method m){
        Object[][] oo=null;
        if (m.getName().equals("register1")){
            oo=new Object[][]{
                    {"注册用户1","aaaa"},
                    {"注册用户2","bbbb"}
            };
        }else if(m.getName().equals("login3")){
            oo=new Object[][]{
                    {"登录用户1","AAAA"},
                    {"登录用户2","BBBB"}
            };
        }
        return oo;
    }
}
