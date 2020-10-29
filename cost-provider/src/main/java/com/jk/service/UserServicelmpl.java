package com.jk.service;

import com.jk.entity.Fei;
import com.jk.entity.Ordering;
import com.jk.mapper.UserMapper;
import com.jk.pojo.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServicelmpl implements UserService{

    @Resource
    private UserMapper userMapper;

      //费用
    @Override
    public PageResult findPage(Integer currPage, Integer pageSize, Fei seo) {
        //1、查询总条数
        Long total = userMapper.findTotal(seo);
        //2、查询每页展示数据
        List<Fei> productList = userMapper.findPage(currPage, pageSize, seo);
        Long totalPage = total%pageSize == 0 ? total/pageSize : (total/pageSize + 1);
        return new PageResult(total, productList, currPage, pageSize, totalPage);
    }

    @Override
    public void add(Fei seo) {
        if(seo.getId()==null){
            userMapper.add(seo);
        }else{
            userMapper.update(seo);
        }
    }



    @Override
    public Fei huixian(Integer id) {
        return userMapper.huixian(id);
    }

    @Override
    public void del(String[] id) {
        for (int i = 0; i < id.length; i++) {
            userMapper.del((Integer.parseInt(id[i])));
        }
    }


    //订餐
    @Override
    public PageResult chaxun(Integer currPage, Integer pageSize, Ordering ordering) {
        //1、查询总条数
        Long total = userMapper.findTotalx(ordering);
        //2、查询每页展示数据
        List<Ordering> productList = userMapper.findPagex(currPage, pageSize, ordering);
        Long totalPage = total%pageSize == 0 ? total/pageSize : (total/pageSize + 1);
        return new PageResult(total, productList, currPage, pageSize, totalPage);
    }

    @Override
    public void xin(Ordering ordering) {
        if(ordering.getId()==null){
            userMapper.xin(ordering);
        }
        userMapper.up(ordering);
    }

    @Override
    public void shan(String[] id) {
        for (int i = 0; i < id.length; i++) {
            userMapper.shan((Integer.parseInt(id[i])));
        }
    }

    @Override
    public Ordering hui(Integer id) {
        return userMapper.hui(id);
    }


}
