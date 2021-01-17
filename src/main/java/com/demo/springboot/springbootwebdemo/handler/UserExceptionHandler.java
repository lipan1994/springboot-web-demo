package com.demo.springboot.springbootwebdemo.handler;

import com.demo.springboot.springbootwebdemo.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * description: 用来捕获异常信息
 * @author: lipan
 * @date: 2021/1/17 10:31
 */
@ControllerAdvice
public class UserExceptionHandler  {

    /**
     * 前后端分离，后端返回json即可
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String,Object> handleException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        return map;
    }
}

