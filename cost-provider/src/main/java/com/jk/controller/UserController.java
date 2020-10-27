package com.jk.controller;


import com.jk.entity.Fei;
import com.jk.pojo.PageResult;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class UserController {

          @Resource
          private UserService userService;

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestParam(value = "currPage", defaultValue = "1") Integer currPage, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,@RequestBody Fei seo) {
        return userService.findPage(currPage, pageSize, seo);
    }

    @RequestMapping("/add")
    public void add(@RequestBody Fei seo){

        userService.add(seo);
    }

    @RequestMapping("/del")
    public void del(@RequestParam String[] id){

        userService.del(id);
    }

    @RequestMapping("/huixian")
    public Fei huixian(@RequestParam Integer id){
        return userService.huixian(id);
    }


}
