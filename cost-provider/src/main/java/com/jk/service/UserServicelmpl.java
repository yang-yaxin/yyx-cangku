package com.jk.service;

import com.jk.entity.*;
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

    //权限加树
    @Override
    public SysUser selectUserInfoByCode(String userCode) {
        return userMapper.selectUserInfoByCode(userCode);
    }

    @Override
    public List<Tree> selectTreeList(Integer userId) {
        Integer pid = 1;
        List<Tree> treeList = nodesList(pid, userId);
        return treeList;
    }

    @Override
    public List<String> selectPowerKeyList(Integer userId) {
        return userMapper.selectPowerKeyList(userId);
    }

    private List<Tree> nodesList(Integer pid, Integer userId){
        List<Tree> treeList = userMapper.selectTreeList(pid, userId);
        for (Tree tree :
                treeList) {
            List<Tree> nodeList = nodesList(tree.getId(), userId);
            // 没有子节点
            if(nodeList == null || nodeList.size() <= 0) {
                tree.setSelectable(true);
                tree.setLeaf(true);
            } else {
                tree.setSelectable(false);
                tree.setNodes(nodeList);
            }
        }
        return treeList;
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


   //店铺分类
    @Override
    public PageResult dianpu(Integer currPage, Integer pageSize, Storeclassification storeclassification) {
        //1、查询总条数
        Long total = userMapper.findTotala(storeclassification);
        //2、查询每页展示数据
        List<Storeclassification> productList = userMapper.findPagea(currPage, pageSize, storeclassification);
        Long totalPage = total%pageSize == 0 ? total/pageSize : (total/pageSize + 1);
        return new PageResult(total, productList, currPage, pageSize, totalPage);
    }

    @Override
    public void dianxin(Storeclassification storeclassification) {
        if(storeclassification.getId()==null){
            userMapper.dianxin(storeclassification);
        }
        userMapper.dianupdate(storeclassification);
    }

    @Override
    public void dianshan(String[] id) {
        for (int i = 0; i < id.length; i++) {
            userMapper.dianshan((Integer.parseInt(id[i])));
        }
    }

    @Override
    public Storeclassification dianhui(Integer id) {
        return userMapper.dianhui(id);
    }


}
