package com.demo.springboot.springbootwebdemo.config;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author: lipan
 * @date: 2021/1/13 21:30
 * @descrption：国际化支持
 */

public class I18nResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language = request.getParameter("l");
        if(!ObjectUtils.isEmpty(language)){
            String[] split = language.split("_");
            return new Locale(split[0],split[1]);
        }
        return Locale.getDefault();
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
