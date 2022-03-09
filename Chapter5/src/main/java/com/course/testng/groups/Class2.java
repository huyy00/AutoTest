package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "Class2")
public class Class2 {
    public void stu1(){
        System.out.println("calss2中的stu11111");
    }

    public void stu2(){
        System.out.println("calss2中的stu22222");
    }
}
