package com.hyy.hyy.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api
public class GetController {


    @GetMapping("getCookies")
    @ApiOperation("一个获取cookies值的方法")
    public String getCookies(HttpServletResponse response){
        Cookie cookie=new Cookie("login","true");
        response.addCookie(cookie);
        return "test";
    }

    /**
     * 携带cookies访问get
     * @return
     */
    @GetMapping("getWithCookies")
    @ApiOperation("一个携带cookies访问get的方法")
    public String getWithCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "需要携带cookies访问";
        }
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("login")&&cookie.getValue().equals("true")){
                return "访问成功";
            }
        }
        return "cookies错误";
    }

    /**
     * 带参数的get请求 第一种方式
     */
    @GetMapping("getProductList")
    @ApiOperation("一个带参数的get请求 第一种")
    public Map getProductList(@RequestParam int start,@RequestParam int end){
        Map list=new HashMap();
        list.put("鞋子",200);
        list.put("裙子",500);
        list.put("裤子",100);

        return list;
    }

    /**
     * 带参数的get请求 第二种方式
     */
    @GetMapping("getProductList2/{start}/{end}")
    @ApiOperation("一个带参数的get请求 第二种")
    public  Map getProductList2(@PathVariable int start, @PathVariable int end){
        Map list=new HashMap();
        list.put("鞋子",200);
        list.put("裙子",500);
        list.put("裤子",100);

        return list;
    }
}
