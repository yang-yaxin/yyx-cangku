package com.jk.service;

import com.jk.entity.OrderEntity;

import java.util.List;

public interface OrderService {
    List<OrderEntity> orderList();

    void saveOrder(OrderEntity order);

    OrderEntity findOrderOne(Integer orderId);

    void deleteOrderByIds(String[] orderIds);
}
