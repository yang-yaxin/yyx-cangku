package com.jk.service.impl;

import com.jk.dao.OrderMapper;
import com.jk.entity.OrderEntity;
import com.jk.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderMapper orderMapper;
    @Override
    public List<OrderEntity> orderList() {

        return orderMapper.orderList();
    }

    @Override
    public void saveOrder(OrderEntity order) {
        if(order.getOrderId()!=null){
            orderMapper.updateByPrimaryKeySelective(order);
        }else{
            orderMapper.insertSelective(order);
        }
    }

    @Override
    public OrderEntity findOrderOne(Integer orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public void deleteOrderByIds(String[] orderIds) {
        for (int i = 0; i < orderIds.length; i++) {
            orderMapper.deleteByPrimaryKey(Integer.parseInt(orderIds[i]));
        }
    }
}
