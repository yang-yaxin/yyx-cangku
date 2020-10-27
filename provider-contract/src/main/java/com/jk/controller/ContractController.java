package com.jk.controller;

import com.jk.entity.Contract;
import com.jk.pojo.PageResult;
import com.jk.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
public class ContractController {
    @Resource
    private ContractService contractService;
    @RequestMapping("ContractList")
    public PageResult ContractList(@RequestParam(value = "currPage", defaultValue = "1") Integer currPage, @RequestParam(value = "pageSize", defaultValue = "2") Integer pageSize,@RequestBody Contract contract){
        return contractService.ContractList(currPage,pageSize,contract);
    }
    @RequestMapping("deleteContractByIds")
    public void deleteContractByIds(@RequestParam String[] ids){
        contractService.deleteContractByIds(ids);
    }
    @RequestMapping("saveContract")
    public void saveContract(@RequestBody Contract contract){

        contract.setEffectiveDate(new Date());
        contractService.saveContract(contract);
    }
    @RequestMapping("findContractOne")
    public Contract findContractOne(@RequestParam Integer id){
        return contractService.findContractOne(id);
    }
}
