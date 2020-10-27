package com.jk.service;

import com.jk.entity.Fei;
import com.jk.pojo.PageResult;

public interface UserService {
    PageResult findPage(Integer currPage, Integer pageSize, Fei seo);

    void add(Fei seo);


    Fei huixian(Integer id);

    void del(String[] id);
}
