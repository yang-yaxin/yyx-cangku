package com.jk.dao;

import com.jk.entity.Personnel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface PersonnelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Personnel record);

    int insertSelective(Personnel record);

    Personnel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Personnel record);

    int updateByPrimaryKey(Personnel record);

    Long count( @Param("personnel")Personnel personnel);

    List<Personnel> personnelList(@Param("currPage") Integer currPage, @Param("pageSize") Integer pageSize, @Param("personnel") Personnel personnel);
}