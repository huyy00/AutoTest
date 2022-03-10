package com.course.testng.thread;

import org.testng.annotations.Test;

public class ThreadOnAnnotation {
    @Test(invocationCount = 10,threadPoolSize = 5)
    public void thread(){
        System.out.println(1);
        System.out.printf("线程id: %s%n",Thread.currentThread().getId());
    }
}
