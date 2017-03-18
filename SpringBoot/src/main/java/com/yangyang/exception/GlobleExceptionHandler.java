package com.yangyang.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobleExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String defaulExceptiontHandler(HttpServletRequest req,Exception e){
        return "soryy ... this is 404 page !!! info: "+e.getMessage();
    }
}
