package com.jk.entity;

import lombok.Data;

@Data
public class Fei {
      private Integer id;
      private Integer type; //报销类型id
      private Integer price;
      private Integer ren; //报销人id
      private Integer status;
      private String date;

      private String china;
      private String green;
}
