package com.jk.service;

import com.jk.entity.Contract;
import com.jk.pojo.PageResult;

public interface ContractService {
    PageResult ContractList(Integer currPage, Integer pageSize, Contract contract);

    void deleteContractByIds(String[] contractIds);

    void saveContract(Contract contract);

    Contract findContractOne(Integer id);
}
