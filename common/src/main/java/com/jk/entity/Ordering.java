package com.jk.entity;


import lombok.Data;

@Data
public class Ordering {

        private Integer id;

        private Integer ding; //订餐人id

        private Integer price;

        private Integer tao; //套餐id

        //业务字段
        private String yewu;
        private String yewu2;
}
