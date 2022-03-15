package com.example.chapter11.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping("test")
public class demo1 {

    @Autowired
    private SqlSessionTemplate template;

    @ApiOperation("获取用户数量")
    @GetMapping("getUserCount")
    public Integer getUserCount(){
        return template.selectOne("getUserCount");
    }

}
