package com.jk.entity;


import lombok.Data;

@Data
public class Storeclassification {

          private Integer id;

          private String img;

          private Integer type; //分类名称id

          private Integer price;

          private String dizhi;

          private Integer status;

          //业务字段
          private String china;

}
