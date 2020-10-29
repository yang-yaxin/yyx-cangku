package com.jk.controller;

import com.jk.entity.Fei;
import com.jk.entity.Ordering;
import com.jk.pojo.PageResult;
import com.jk.service.UserService;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    //费用管理

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestParam(value = "currPage", defaultValue = "1") Integer currPage, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,  Fei seo) {
        return userService.findPage(currPage, pageSize,seo);
    }

    @RequestMapping("/add")
    public void add(Fei seo){

        userService.add(seo);
    }

    @RequestMapping("/del")
    public void del(String[] id){

        userService.del(id);
    }

    @RequestMapping("/huixian")
    public Fei huixian(Integer id){
        return userService.huixian(id);
    }




    //订餐管理
    @RequestMapping("/chaxun")
    public PageResult chaxun(@RequestParam(value = "currPage", defaultValue = "1") Integer currPage, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Ordering ordering) {
        return userService.chaxun(currPage, pageSize, ordering);
    }

    @RequestMapping("/xin")
    public void xin(Ordering ordering){
        userService.xin(ordering);
    }

    @RequestMapping("/shan")
    public void shan(String[] id){

        userService.shan(id);
    }
    @RequestMapping("/hui")
    public Ordering hui(@RequestParam Integer id){
        return userService.hui(id);
    }

}
