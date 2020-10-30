package com.jk.controller;

import com.jk.entity.Contract;
import com.jk.pojo.PageResult;
import com.jk.service.ContractService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class ContractController {
    @Resource
    private ContractService contractService;
    @RequestMapping("contract")
    @RequiresPermissions("contract:query")
    public String contract(){
        return "contract";
    }

    @RequestMapping("addContract")
    @RequiresPermissions("contract:save")
    public String addContract(Model model){
        model.addAttribute("contract",new Contract());
        return "addContract";
    }
    @RequestMapping("ContractList")
    @ResponseBody
    @RequiresPermissions("contract:query")
    public PageResult ContractList(@RequestParam(value = "currPage", defaultValue = "1") Integer currPage, @RequestParam(value = "pageSize", defaultValue = "2") Integer pageSize,
                                   Contract contract){
        return contractService.ContractList(currPage,pageSize,contract);
    }

    @RequestMapping("deleteContractByIds")
    @ResponseBody
    @RequiresPermissions("contract:delete")
    public void deleteContractByIds(String[] ids){
        contractService.deleteContractByIds(ids);
    }

    @RequestMapping("saveContract")
    @RequiresPermissions("contract:save")
    public String saveContract( Contract contract){
        contractService.saveContract(contract);
        return "redirect:contract";
    }

    @RequestMapping("findContractOne")
    @RequiresPermissions("contract:update")
    public String findContractOne(Integer id,Model model){
        Contract contract=contractService.findContractOne(id);
        model.addAttribute("contract",contract);
        return "addContract";
    }
}
