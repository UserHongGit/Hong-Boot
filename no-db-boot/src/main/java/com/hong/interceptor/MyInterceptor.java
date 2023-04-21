package com.hong.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class MyInterceptor implements HandlerInterceptor{
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map map = new HashMap<>();
        map.put("key","Interceptor");
        threadLocal.set(map);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
