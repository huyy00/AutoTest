package com.course.testng;

import org.testng.annotations.Test;

//依赖测试
public class Depend {
    @Test
    public void test1(){
        System.out.println("test11111");
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2222");

    }

}
