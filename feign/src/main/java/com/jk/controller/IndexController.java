package com.jk.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    @RequestMapping("/index")
    @RequiresPermissions("fei:query")
    public String memberRankList() {
        return "cgs/index";
    }

    @RequestMapping("/dingcan")
    @RequiresPermissions("ding:query")
    public String dingcan() {
        return "cgs/dingcan";
    }

    @RequestMapping("/china")
    public String china(){
        return "show";
    }

    @RequestMapping("page/toLogin")
    public String tologin(){
        return "login";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/dianpu")
    public String dianpu() {
        return "cgs/dianpu";
    }

}
