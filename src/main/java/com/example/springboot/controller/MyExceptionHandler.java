package com.example.springboot.controller;

import com.example.springboot.exception.UserNotExistException;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {
    //1、浏览器和客户端返回的都是json数据
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String,String> myExceptionHandler(Exception e){
//        Map<String,String> map=new HashMap<>();
//        map.put("message",e.getMessage());
//        return map;
//    }

    @ExceptionHandler(UserNotExistException.class)
    public String myExceptionHandler(Exception e, HttpServletRequest request){
        Map<String,String> map=new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("message","自定义错误提示信息");
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
