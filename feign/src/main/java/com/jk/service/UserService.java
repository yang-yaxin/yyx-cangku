package com.jk.service;

import com.jk.entity.Fei;
import com.jk.pojo.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "cost-provider")
public interface UserService {

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestParam(value = "currPage", defaultValue = "1") Integer currPage, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody Fei seo);


    @RequestMapping("/add")
    public void add(@RequestBody Fei seo);

    @RequestMapping("/del")
    public void del(@RequestParam String[] id);

    @RequestMapping("/huixian")
    public Fei huixian(@RequestParam Integer id);
}
