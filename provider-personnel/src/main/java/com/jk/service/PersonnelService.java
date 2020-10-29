package com.jk.service;

import com.jk.entity.Personnel;
import com.jk.pojo.PageResult;

public interface PersonnelService {
    PageResult personnelList(Integer currPage, Integer pageSize, Personnel personnel);

    void savePersonnel(Personnel personnel);

    Personnel findPersonnelOne(Integer id);
}
