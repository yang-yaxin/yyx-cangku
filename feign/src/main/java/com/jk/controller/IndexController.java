package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    @RequestMapping("/index")
    public String memberRankList() {
        return "cgs/index";
    }

    @RequestMapping("/dingcan")
    public String dingcan() {
        return "cgs/dingcan";
    }


    @RequestMapping("/china")
    public String china(){
        return "show";
    }

}
