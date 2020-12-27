package com.keepal.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLoginInterceptor implements HandlerInterceptor {
    
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)
                             throws Exception {
        // 在处理之前，校验是否登录——就是有没有带_login=true
    	Boolean result = Boolean.valueOf(request.getParameter("_login"));    
    	return result;
    }
    
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView moodelAndView)
                           throws Exception {
    
    }
    
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex)
                                throws Exception {
    
    }
    
}