package com.jk.service.impl;

import com.jk.dao.ContractMapper;
import com.jk.entity.Contract;
import com.jk.pojo.PageResult;
import com.jk.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Resource
    private ContractMapper contractMapper;
    @Override
    public PageResult ContractList(Integer currPage, Integer pageSize, Contract contract) {
        Long total = contractMapper.count(contract);
        //2、查询每页展示数据
        List<Contract> list = contractMapper.ContractList(currPage, pageSize, contract);
        Long totalPage = total%pageSize == 0 ? total/pageSize : (total/pageSize + 1);
        return new PageResult(total, list, currPage, pageSize, totalPage);
    }

    @Override
    public void deleteContractByIds(String[] contractIds) {
        for (int i = 0; i < contractIds.length; i++) {
            contractMapper.deleteByPrimaryKey(Integer.parseInt(contractIds[i]));
        }
    }

    @Override
    public void saveContract(Contract contract) {
        if(contract.getId()!=null){
            contractMapper.updateByPrimaryKeySelective(contract);
        }else{
            contractMapper.insertSelective(contract);
        }
    }

    @Override
    public Contract findContractOne(Integer id) {
        return contractMapper.selectByPrimaryKey(id);
    }
}
