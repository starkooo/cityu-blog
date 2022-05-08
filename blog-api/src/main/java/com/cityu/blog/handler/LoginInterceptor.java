package com.cityu.blog.handler;

import com.alibaba.fastjson.JSON;
import com.cityu.blog.dao.pojo.SysUser;
import com.cityu.blog.service.LoginService;
import com.cityu.blog.utils.UserThreadLocal;
import com.cityu.blog.vo.ErrorCode;
import com.cityu.blog.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //在执行controller方法（Handler）之前进行执行
        /**
         * 1. 需要判断请求的接口路径是否为HandlerMethod（Controller方法）
         * 2. token是否为空，为空则未登录
         * 3. token不为空，登录验证loginService checkToken
         * 4. 认证成功，放行
         */
        if (!(handler instanceof HandlerMethod)) {
            //handler 可能是资源handler（RequestResourceHandler）
            return true;
        }
        String token = request.getHeader("Authorization");

        log.info("=================request start===========================");
        String requestURI = request.getRequestURI();
        log.info("request uri:{}",requestURI);
        log.info("request method:{}",request.getMethod());
        log.info("token:{}", token);
        log.info("=================request end===========================");


        if (StringUtils.isBlank(token)){
            Result result = Result.fail(ErrorCode.NO_LOGIN.getCode(), "未登录");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        SysUser sysUser = loginService.checkToken(token);
        if (sysUser==null){
            Result result = Result.fail(ErrorCode.NO_LOGIN.getCode(), "未登录");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        //登陆验证成功，放行
        //在这里希望直接在controller中获取用户信息，如何获取？
        UserThreadLocal.put(sysUser);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //如果不删除ThreadLocal中用完的信息，会有内存泄漏风险
        UserThreadLocal.remove();
    }
}
