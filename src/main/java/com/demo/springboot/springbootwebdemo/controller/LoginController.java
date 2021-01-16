package com.demo.springboot.springbootwebdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author: lipan
 * @date: 2021/1/14 20:34
 */

@Controller
public class LoginController {


    @PostMapping(value = "/user/login")
    public String login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, Map map, HttpSession session){
             if(!ObjectUtils.isEmpty(username) && "guest".equals(password)){
                 session.setAttribute("username",username);
                 return "redirect:/maintain.html";
             }else{
                 map.put("msg","用户名或密码错误");
                 return "index";
             }
    }

}
