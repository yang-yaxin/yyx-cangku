package com.jk.service;

import com.jk.entity.Fei;
import com.jk.entity.SysUser;
import com.jk.entity.Tree;
import com.jk.pojo.PageResult;

import java.util.List;

public interface UserService {
    PageResult findPage(Integer currPage, Integer pageSize, Fei seo);

    void add(Fei seo);


    Fei huixian(Integer id);

    void del(String[] id);

    SysUser selectUserInfoByCode(String userCode);

    List<Tree> selectTreeList(Integer userId);

    List<String> selectPowerKeyList(Integer userId);
}
