package com.demo.springboot.springbootwebdemo.exception;

/**
 * @author: lipan
 * @date: 2021/1/17 10:34
 */

public class UserNotExistException extends RuntimeException {

    //
    public UserNotExistException() {
        super("用户不存在");
    }


}
