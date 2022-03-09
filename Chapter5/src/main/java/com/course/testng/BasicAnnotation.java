package com.course.testng;

import org.testng.annotations.*;
//基础注解
public class BasicAnnotation {
    @Test
    public void testCase1(){
        System.out.println("测试用例1");
    }

    @Test
    public void testCase2(){
        System.out.println("测试用例2");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass Method之前执行");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass Method之后执行");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod 用例之前执行");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod 用例之后执行");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest class执行之前执行的");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest class执行之后执行的");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite Test之前执行");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite Test之后执行的");
    }

    @Test(enabled = false)
    public void ignore(){
        System.out.println("ignore");
    }

}
