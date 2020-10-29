package com.jk.controller;

import com.jk.entity.Fei;
import com.jk.entity.Ordering;
import com.jk.pojo.PageResult;
import com.jk.service.UserService;


import com.jk.entity.SysUser;
import com.jk.entity.Tree;
import com.jk.pojo.PageResult;
import com.jk.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    //费用管理

    @RequestMapping("/findPage")
    @RequiresPermissions("fei:query")
    public PageResult findPage(@RequestParam(value = "currPage", defaultValue = "1") Integer currPage, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,  Fei seo) {
        return userService.findPage(currPage, pageSize,seo);
    }

    @RequestMapping("/add")
    @RequiresPermissions("fei:save")
    public void add(Fei seo){

        userService.add(seo);
    }

    @RequestMapping("/del")
    @RequiresPermissions("fei:delete")
    public void del(String[] id){

        userService.del(id);
    }

    @RequestMapping("/huixian")
    @RequiresPermissions("fei:update")
    public Fei huixian(Integer id){
        return userService.huixian(id);
    }





    //订餐管理
    @RequestMapping("/chaxun")
    @RequiresPermissions("ding:query")
    public PageResult chaxun(@RequestParam(value = "currPage", defaultValue = "1") Integer currPage, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, Ordering ordering) {
        return userService.chaxun(currPage, pageSize, ordering);
    }

    @RequestMapping("/xin")
    @RequiresPermissions("ding:save")
    public void xin(Ordering ordering){
        userService.xin(ordering);
    }

    @RequestMapping("/shan")
    @RequiresPermissions("ding:delete")
    public void shan(String[] id){

        userService.shan(id);
    }
    @RequestMapping("/hui")
    @RequiresPermissions("ding:update")
    public Ordering hui(@RequestParam Integer id){
        return userService.hui(id);
    }


    @RequestMapping("/user/login")
    public String login(SysUser user) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken upt = new UsernamePasswordToken(user.getUsercode(), user.getPassword());
        try {
            // 不抛异常代表登录成功
            subject.login(upt);
            return "登录成功";
        } catch (UnknownAccountException uae) {
            return "账号不存在";
        } catch (IncorrectCredentialsException ice) {
            return "密码错误";
        } catch (AuthenticationException ae) {
            return "登录失败，网络错误";
        }
    }

    @RequestMapping("user/queryTree")
    public List<Tree> queryTree() {
        System.out.println("登录成功");
        //查询当前用户所属的权限树
        SysUser user = (SysUser)SecurityUtils.getSubject().getPrincipal();
        return userService.selectTreeList(user.getId());
    }

}
