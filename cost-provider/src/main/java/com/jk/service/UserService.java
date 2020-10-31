package com.jk.service;

import com.jk.entity.*;
import com.jk.pojo.PageResult;

import java.util.List;

public interface UserService {
    //费用
    PageResult findPage(Integer currPage, Integer pageSize, Fei seo);

    void add(Fei seo);


    Fei huixian(Integer id);

    void del(String[] id);


    //订餐
    PageResult chaxun(Integer currPage, Integer pageSize, Ordering ordering);

    void xin(Ordering ordering);

    void shan(String[] id);

    Ordering hui(Integer id);
    SysUser selectUserInfoByCode(String userCode);

    List<Tree> selectTreeList(Integer userId);

    List<String> selectPowerKeyList(Integer userId);

    //店铺分类

    PageResult dianpu(Integer currPage, Integer pageSize, Storeclassification storeclassification);

    void dianxin(Storeclassification storeclassification);

    void dianshan(String[] id);

    Storeclassification dianhui(Integer id);
}
