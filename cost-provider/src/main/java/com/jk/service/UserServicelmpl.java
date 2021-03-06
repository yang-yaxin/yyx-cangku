package com.jk.service;

import com.jk.entity.Fei;
import com.jk.entity.SysUser;
import com.jk.entity.Tree;
import com.jk.mapper.UserMapper;
import com.jk.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServicelmpl implements UserService{

    @Resource
    private UserMapper userMapper;

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



}
