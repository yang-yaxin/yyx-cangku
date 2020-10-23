package com.jk.entity;

import lombok.Data;

@Data
public class OrderEntity {
    private Integer orderId;

    private String orderNo;

    private String orderName;

    private Integer orderPrice;

    private String orderTime;

    private Integer orderMode;

    private String modeName;
}
