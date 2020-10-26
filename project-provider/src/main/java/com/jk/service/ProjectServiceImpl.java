package com.jk.service;

import com.jk.entity.Project;
import com.jk.mapper.ProjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Resource
    private ProjectMapper projectMapper;

    @Override
    public List<Project> findAll(Project project) {
        return projectMapper.findAll(project);
    }

    @Override
    public void addProject(Project project) {
        projectMapper.insertSelective(project);
    }

    @Override
    public Project findProjectById(Integer id) {
        return projectMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateProject(Project project) {
        projectMapper.updateByPrimaryKeySelective(project);
    }

    @Override
    public void deleteByIds(String[] ids) {
        projectMapper.deleteByIds(ids);
    }
}
