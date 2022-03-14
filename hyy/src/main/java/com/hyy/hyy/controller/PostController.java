package com.hyy.hyy.controller;

import com.hyy.hyy.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api
public class PostController {

    private static Cookie cookie;

    @PostMapping("login")
    @ApiOperation(value = "一个登陆接口",httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "name",required = true) String name,
                        @RequestParam(value = "pwd",required = true) String pwd){
        if (name.equals("zhangsan")&&pwd.equals("123")){
            cookie=new Cookie("login","true");
            response.addCookie(cookie);
            return "登陆成功";
        }
        return "登陆失败";
    }

    @PostMapping("getUserList")
    @ApiOperation(value = "一个获取用户列表的接口",httpMethod = "POST")
    public String getUserList(HttpServletRequest request,
                              @RequestBody User user){
        User u;
        //获取cookies
        Cookie[] cookies=request.getCookies();
        for (Cookie c:cookies){
            if (c.getName().equals("login")&&c.getValue().equals("true")
                    &&user.getName().equals("zhangsan")&&user.getPwd().equals("123")){
                u=new User();
                u.setName("lisi");
                u.setAge("15");
                return u.toString();
            }
        }
        return "获取列表失败";
    }
}
