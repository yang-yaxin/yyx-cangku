package com.jk.controller;

import com.jk.entity.Personnel;
import com.jk.pojo.PageResult;
import com.jk.service.PersonnelService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class PersonnelController {
    @Resource
    private PersonnelService personnelService;

    @RequestMapping("personnel")
    public String personnel(){

        return "personnel/personnel";
    }
    @RequestMapping("personnelList")
    @ResponseBody
    @RequiresPermissions("personnel:query")
    public PageResult personnelList(@RequestParam(value = "currPage", defaultValue = "1") Integer currPage, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,Personnel personnel){
        return personnelService.personnelList(currPage,pageSize,personnel);
    }

    @RequestMapping("savePersonnel")
    @ResponseBody
    @RequiresPermissions("personnel:save")
    public void savePersonnel(Personnel personnel){
        personnelService.savePersonnel(personnel);
    }

    @RequestMapping("findPersonnelOne")
    @ResponseBody
    @RequiresPermissions("personnel:update")
    public Personnel findPersonnelOne(Integer id){
        return personnelService.findPersonnelOne(id);
    }

    @RequestMapping("deletePersonnelOne")
    @ResponseBody
    @RequiresPermissions("personnel:delete")
    public void deletePersonnelOne(Integer id){

        personnelService.deletePersonnelOne(id);
    }

}
