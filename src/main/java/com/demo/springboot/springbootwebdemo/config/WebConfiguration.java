package com.demo.springboot.springbootwebdemo.config;

import com.demo.springboot.springbootwebdemo.interceptors.LoginHandlerInterceptor;
import com.demo.springboot.springbootwebdemo.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

import javax.servlet.Servlet;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: lipan
 * @date: 2021/1/12 21:30
 */

@Configuration
public class WebConfiguration implements WebMvcConfigurer{


    public static  final String [] EXCLUDE_STATIC_RESOURCE=new String[]{"/asserts/css/**","/asserts/js/**","/asserts/img/**"};

    /**
     * 增加首页的配置,相当于在controller中加请求路径与视图资源配置一样
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/maintain.html").setViewName("dashboard");
    }

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
         registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/index.html","/user/login").excludePathPatterns(EXCLUDE_STATIC_RESOURCE);
    }

    @Bean(name="localeResolver")
    public LocaleResolver i18nResolver(){
        return new I18nResolver();
    }


    @Bean
    public WebServerFactoryCustomizer  webServerFactoryCustomizer(){

        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(9091);
            }
        };



    }

    @Bean
    public ServletRegistrationBean myServlet(){

        ServletRegistrationBean<Servlet> servletServletRegistrationBean = new ServletRegistrationBean<>();
        servletServletRegistrationBean.setServlet(new MyServlet());
        servletServletRegistrationBean.setUrlMappings( Arrays.asList("/MyServlet"));
        return  servletServletRegistrationBean;
    }


}
