package com.jk.mapper;

import com.jk.entity.Project;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Project project);

    int insertSelective(Project project);

    Project selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Project project);

    int updateByPrimaryKey(Project project);

    List<Project> findAll(Project project);

    void deleteByIds(String[] ids);
}