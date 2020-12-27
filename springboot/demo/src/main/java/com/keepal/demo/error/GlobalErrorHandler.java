package com.keepal.demo.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 通过@ControllerAdvice注解实现全局异常捕捉
 *
 * 通常我们都会自定义异常，然后返回对应的异常信息
 */
@ControllerAdvice
class GlobalErrorHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorInfo<String> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
    	ErrorInfo<String> r = new ErrorInfo<String>();  
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("自定义的全局异常处理");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }

}