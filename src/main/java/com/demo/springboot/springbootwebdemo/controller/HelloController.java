package com.demo.springboot.springbootwebdemo.controller;

import com.demo.springboot.springbootwebdemo.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author: lipan
 * @date: 2021/1/11 21:55
 */

@Controller
public class HelloController {



    @RequestMapping("/success")
    public  String success(Map<String,String> map){
        map.put("name","张三");
        return "success";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(String user){
        if("aaa".equals(user)){
            throw  new UserNotExistException();
        }
        return "hello";
    }
}
