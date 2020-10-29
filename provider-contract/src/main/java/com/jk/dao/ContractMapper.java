package com.jk.dao;

import com.jk.entity.Contract;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContractMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Contract record);

    int insertSelective(Contract record);

    Contract selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);

    Long count(@Param("contract")Contract contract);

    List<Contract> ContractList(@Param("currPage") Integer currPage,@Param("pageSize") Integer pageSize,@Param("contract") Contract contract);
}