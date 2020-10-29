package com.jk.service;

import com.jk.entity.Fei;
import com.jk.entity.Ordering;
import com.jk.entity.SysUser;
import com.jk.entity.Tree;
import com.jk.pojo.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "cost-provider")
public interface UserService {
    //费用
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestParam(value = "currPage", defaultValue = "1") Integer currPage, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody Fei seo);


    @RequestMapping("/add")
    public void add(@RequestBody Fei seo);

    @RequestMapping("/del")
    public void del(@RequestParam String[] id);

    @RequestMapping("/huixian")
    public Fei huixian(@RequestParam Integer id);


    //订餐
    @RequestMapping("/chaxun")
    public PageResult chaxun(@RequestParam(value = "currPage", defaultValue = "1") Integer currPage, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,@RequestBody Ordering ordering);

    @RequestMapping("/xin")
    public void xin(@RequestBody Ordering ordering);

    @RequestMapping("/shan")
    public void shan(@RequestParam String[] id);

    @RequestMapping("/hui")
    public Ordering hui(@RequestParam Integer id);

    @RequestMapping("/selectUserInfoByCode")
    SysUser selectUserInfoByCode(@RequestParam String userCode);
    @RequestMapping("/selectTreeList")
    List<Tree> selectTreeList(@RequestParam Integer userId);

    @RequestMapping("/selectPowerKeyList")
    List<String> selectPowerKeyList(@RequestParam Integer userId);

}
