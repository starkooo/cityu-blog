package com.cityu.blog.controller;

import com.cityu.blog.service.LoginService;
import com.cityu.blog.vo.Result;
import com.cityu.blog.vo.params.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result register(@RequestBody LoginParam loginParam){
        //sso单点登录，后期可以把登陆注册功能提出来（单独的服务，可以独立提供接口服务）
        return loginService.register(loginParam);
    }
}
