package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class Groups {

    //方法分组 注解
    @Test(groups = "server")
    public void groupsOnServer(){
        System.out.println("服务端的组");
    }


    @Test(groups = "client")
    public void groupsOnClient(){
        System.out.println("客户端的组");
    }

    @BeforeGroups("client")
    public void beforeGroups(){
        System.out.println("在这个组之前运行的方法");
    }

    @AfterGroups("client")
    public void afterGroups(){
        System.out.println("在这个组之后运行的方法");
    }
}
