package com.jk.service;

import com.jk.entity.Personnel;
import com.jk.pojo.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="provider-personnel")
public interface PersonnelService {
    @RequestMapping("personnelList")
    public PageResult personnelList(@RequestParam(value = "currPage", defaultValue = "1") Integer currPage, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize, @RequestBody Personnel personnel);

    @RequestMapping("savePersonnel")
    public void savePersonnel(@RequestBody Personnel personnel);
    @RequestMapping("findPersonnelOne")
    public Personnel findPersonnelOne(@RequestParam Integer id);

    @RequestMapping("deletePersonnelOne")
    public void deletePersonnelOne(@RequestParam Integer id);
}
