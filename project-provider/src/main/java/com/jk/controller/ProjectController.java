package com.jk.controller;

import com.jk.entity.Project;
import com.jk.service.ProjectService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Resource
    private ProjectService projectService;

    /**
     * 列表
     * @param Project
     * @return
     */
    @RequestMapping("/findAll")
    public List<Project> findAll(@RequestBody Project project){
        return projectService.findAll(project);
    }

    /**
     * 新增
     * @param Project
     */
    @RequestMapping("/addProject")
    public void addProject(@RequestBody Project project){
        projectService.addProject(project);
    }

    /**
     * 回显
     * @param id
     * @return
     */
    @RequestMapping("/findProjectById")
    public Project findProjectById(@RequestParam(value="id") Integer id){
        return  projectService.findProjectById(id);
    }

    /**
     * 修改
     * @param Project
     */
    @RequestMapping("/updateProject")
    public void updateProject(@RequestBody Project Project){
        projectService.updateProject(Project);
    }

    @RequestMapping("/deleteByIds")
    public void deleteByIds(@RequestParam(value="ids") String[] ids){
        projectService.deleteByIds(ids);
    }
}

