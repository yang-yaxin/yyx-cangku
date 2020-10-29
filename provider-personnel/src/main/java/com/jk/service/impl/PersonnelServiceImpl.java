package com.jk.service.impl;

import com.jk.dao.PersonnelMapper;
import com.jk.entity.Personnel;
import com.jk.pojo.PageResult;
import com.jk.service.PersonnelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonnelServiceImpl implements PersonnelService {
    @Resource
    private PersonnelMapper personnelMapper;
    @Override
    public PageResult personnelList(Integer currPage, Integer pageSize, Personnel personnel) {
        Long total = personnelMapper.count(personnel);
        //2、查询每页展示数据
        List<Personnel> list = personnelMapper.personnelList(currPage, pageSize, personnel);
        Long totalPage = total%pageSize == 0 ? total/pageSize : (total/pageSize + 1);
        return new PageResult(total, list, currPage, pageSize, totalPage);
    }

    @Override
    public void savePersonnel(Personnel personnel) {
        if(personnel.getId()!=null){
            personnelMapper.updateByPrimaryKeySelective(personnel);
        }else{
            personnelMapper.insertSelective(personnel);
        }
    }

    @Override
    public Personnel findPersonnelOne(Integer id) {
        return personnelMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deletePersonnelOne(Integer id) {
        personnelMapper.deleteByPrimaryKey(id);
    }
}
