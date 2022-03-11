package com.recouse.tester;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class demo1 {

    @Test
    public void test1(){
        Assert.assertEquals(1,1);
    }

    @Test
    public void test2(){
        Assert.assertEquals(1,3);
    }

    @Test
    public void test3(){
        Assert.assertEquals("qqq","qqq");
    }

    @Test
    public void log(){
        Reporter.log("展示日志");
        throw new RuntimeException("抛出异常");
    }
}

