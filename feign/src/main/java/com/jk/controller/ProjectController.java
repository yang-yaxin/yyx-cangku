package com.jk.controller;

import com.jk.entity.Project;
import com.jk.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
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
    public  String findAll(Project project, Model model){
        List<Project> list=projectService.findAll(project);
        model.addAttribute("projectList",list);
        return "project/list";
    }

    /**
     * 新增页面
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        Project project=new Project();
        model.addAttribute("project",project);
        return "project/add";
    }

    /**
     * 修改页面
     * @return
     */
    @RequestMapping("/toUpdate")
    public String toUpdate(Integer id,Model model){
        Project project=projectService.findProjectById(id);
        model.addAttribute("project",project);
        return "project/add";
    }

    /**
     * 新增
     * @param Project
     */
    @RequestMapping("/addProject")
    @ResponseBody
    public void addProject(Project project){
        project.setStartDate(new Date());
        projectService.addProject(project);
    }

    /**
     * 回显
     * @param id
     * @return
     */
    @RequestMapping("/findProjectById")
    @ResponseBody
    public Project findProjectById(@RequestParam(value="id") Integer id){
        return  projectService.findProjectById(id);
    }

    /**
     * 修改
     * @param Project
     */
    @RequestMapping("/updateProject")
    @ResponseBody
    public void updateProject(Project project){
        projectService.updateProject(project);
    }

    /**
     * 新增|修改
     * @param project
     * @return
     */
    @RequestMapping("/saveProject")
    public String saveProject(Project project){
        if(project.getId()==null){
            projectService.addProject(project);
        }else{
            projectService.updateProject(project);
        }
        return "redirect:findAll";
    }


    /**
     * 批删
     * @param ids
     */
    @RequestMapping("/deleteByIds")
    public String deleteByIds(@RequestParam(value="ids") String[] ids){
        projectService.deleteByIds(ids);
        return "redirect:findAll";
    }
}

