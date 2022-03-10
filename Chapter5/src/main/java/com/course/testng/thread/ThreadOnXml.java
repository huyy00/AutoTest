package com.course.testng.thread;

import org.testng.annotations.Test;

public class ThreadOnXml {

    @Test
    public void test1(){
        System.out.println("线程id:"+Thread.currentThread().getId());
    }

    @Test
    public void test2(){
        System.out.println("线程id:"+Thread.currentThread().getId());
    }

    @Test
    public void test3(){
        System.out.println("线程id:"+Thread.currentThread().getId());
    }
}
