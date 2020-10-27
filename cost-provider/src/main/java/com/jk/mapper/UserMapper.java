package com.jk.mapper;


import com.jk.entity.Fei;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    Long findTotal(@Param("seo") Fei seo);

    List<Fei> findPage(@Param("currPage")Integer currPage, @Param("pageSize")Integer pageSize, @Param("seo")Fei seo);

    void add(Fei seo);


    Fei huixian(Integer id);

    void update(Fei seo);

    void del(int parseInt);
}
