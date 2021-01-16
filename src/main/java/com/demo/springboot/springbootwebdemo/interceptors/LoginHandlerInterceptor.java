package com.demo.springboot.springbootwebdemo.interceptors;

import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: lipan
 * @date: 2021/1/14 21:55
 * @description:登录权限校验
 */

public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       if(ObjectUtils.isEmpty(request.getSession().getAttribute("username"))) {
           request.setAttribute("msg","请先登录");
           request.getRequestDispatcher("/index.html").forward(request,response);
           return false;
       }
        return true;
    }
}

