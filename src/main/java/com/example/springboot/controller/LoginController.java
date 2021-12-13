package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @PostMapping("/user/login")
    public String userLogin(@RequestParam("username")String username,
                            @RequestParam("password")String password,
                            Map<String,Object> map,
                            HttpSession session){

        if(username!=null&&password!=null&&"admin".equals(username)&&"123456".equals(password))
        {
            //登录成功 使用重定向 防止表单重复提交
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        session.setAttribute("msg","用户名密码错误");
        map.put("msg","用户名密码错误");
        return "login";
    }
}
