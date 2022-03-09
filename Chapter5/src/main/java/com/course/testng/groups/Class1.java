package com.course.testng.groups;

import org.testng.annotations.Test;
//类分组 注解
@Test(groups = "Class1")
public class Class1 {

    public void stu1(){
        System.out.println("class1中的stu11111");
    }

    public void stu2(){
        System.out.println("class1中的stu22222");
    }
}
