package com.jk.controller;

import com.jk.entity.Personnel;
import com.jk.pojo.PageResult;
import com.jk.service.PersonnelService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PersonnelController {
    @Resource
    private PersonnelService personnelService;
    @RequestMapping("personnelList")
    public PageResult personnelList(@RequestParam(value = "currPage", defaultValue = "1") Integer currPage, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody Personnel personnel){
        return personnelService.personnelList(currPage,pageSize,personnel);
    }
    @RequestMapping("savePersonnel")
    public void savePersonnel(@RequestBody Personnel personnel){
        personnelService.savePersonnel(personnel);
    }
    @RequestMapping("findPersonnelOne")
    public Personnel findPersonnelOne(@RequestParam Integer id){
        return personnelService.findPersonnelOne(id);
    }
}
