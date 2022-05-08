package com.cityu.blog.service;

import com.cityu.blog.dao.pojo.SysUser;
import com.cityu.blog.vo.Result;
import com.cityu.blog.vo.params.LoginParam;
import org.springframework.transaction.annotation.Transactional;


public interface LoginService {
    /**
     * 登录功能
     * @param loginParam
     * @return
     */
    Result login(LoginParam loginParam);

    SysUser checkToken(String token);

    Result logout(String token);

    Result register(LoginParam loginParam);
}
