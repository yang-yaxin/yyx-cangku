package com.jk.service;

import com.jk.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> findAll(Project project);

    void addProject(Project project);

    Project findProjectById(Integer id);

    void updateProject(Project project);

    void deleteByIds(String[] ids);
}
