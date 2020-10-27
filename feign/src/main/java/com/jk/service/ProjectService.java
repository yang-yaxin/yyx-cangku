package com.jk.service;

import com.jk.entity.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value="project-provider")
public interface ProjectService {
    /**
     * 列表
     * @param Project
     * @return
     */
    @RequestMapping("/project/findAll")
    public List<Project> findAll(@RequestBody Project project);

    /**
     * 新增
     * @param Project
     */
    @RequestMapping("/project/addProject")
    public void addProject(@RequestBody Project project);

    /**
     * 回显
     * @param id
     * @return
     */
    @RequestMapping("/project/findProjectById")
    public Project findProjectById(@RequestParam(value="id") Integer id);

    /**
     * 修改
     * @param Project
     */
    @RequestMapping("/project/updateProject")
    public void updateProject(@RequestBody Project Project);

    @RequestMapping("/project/deleteByIds")
    public void deleteByIds(@RequestParam(value="ids") String[] ids);
}
