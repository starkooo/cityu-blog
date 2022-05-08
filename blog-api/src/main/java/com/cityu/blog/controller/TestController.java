package com.cityu.blog.controller;

import com.cityu.blog.dao.pojo.SysUser;
import com.cityu.blog.utils.UserThreadLocal;
import com.cityu.blog.vo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    @RequestMapping
    public Result test(){
        SysUser sysUser = UserThreadLocal.get();
        System.out.println(sysUser);
        return Result.success(null);
    }
}
