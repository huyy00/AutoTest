package com.course.testng;

import org.testng.annotations.*;

public class BaseAnnotation {

    @Test
    public void testCase1(){
        System.out.print("这是测试用例1");
    }
    @Test
    public void testCase2(){
        System.out.print("这是测试用例2");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.print("BeforeMethod在方法之前执行");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.print("AfterMethod在方法之后执行");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass在类之前执行");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass在类之后执行");
    }
}
