package com.jk.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "HelloWorld";
    }

    @RequestMapping("/port")
    @ResponseBody
    public String port(){
        System.out.println(port);
        return port;
    }

}
