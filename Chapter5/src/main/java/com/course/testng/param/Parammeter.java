package com.course.testng.param;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Parammeter {

    //xml参数化
    @Test
    @Parameters({"name1","pwd1"})
    public void login(String name,String pwd){
        System.out.println("xml参数化 name="+name+";   pwd="+pwd);
    }


    public void login1(){

    }
}
