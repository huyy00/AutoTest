package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "Class3")
public class Class3 {

    public void teacher(){
        System.out.println("只是class3中的teacher");
    }
}
