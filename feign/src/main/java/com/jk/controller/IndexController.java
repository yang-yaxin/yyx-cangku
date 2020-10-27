package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    @RequestMapping("/index")
    public String memberRankList() {
        return "index";
    }

    @RequestMapping("/china")
    public String china(){
        return "show";
    }

}
