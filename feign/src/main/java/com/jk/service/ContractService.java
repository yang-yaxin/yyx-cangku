package com.jk.service;

import com.jk.entity.Contract;
import com.jk.pojo.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="provider-contract")
public interface ContractService {
    @RequestMapping("ContractList")
    public PageResult ContractList(@RequestParam(value = "currPage", defaultValue = "1") Integer currPage, @RequestParam(value = "pageSize", defaultValue = "2") Integer pageSize, @RequestBody Contract contract);
    @RequestMapping("deleteContractByIds")
    public void deleteContractByIds(@RequestParam String[] ids);
    @RequestMapping("saveContract")
    public void saveContract(@RequestBody Contract contract);
    @RequestMapping("findContractOne")
    public Contract findContractOne(@RequestParam Integer id);
}
