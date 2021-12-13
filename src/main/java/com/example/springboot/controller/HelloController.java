package com.example.springboot.controller;

import com.example.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("hello") String hello){
        if (!hello.equals("hello"))
        {
            throw new UserNotExistException("用户并不存在！");
        }
        return "hello world";
    }
}
