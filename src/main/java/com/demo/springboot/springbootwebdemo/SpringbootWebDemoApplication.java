package com.demo.springboot.springbootwebdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringbootWebDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebDemoApplication.class, args);
    }

}
