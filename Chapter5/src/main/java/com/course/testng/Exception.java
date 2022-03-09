package com.course.testng;

import org.testng.annotations.Test;

//异常测试
public class Exception {
    @Test(expectedExceptions = RuntimeException.class)
    public void test1(){
        System.out.println("异常测试111111");
        throw new RuntimeException();
    }
}
