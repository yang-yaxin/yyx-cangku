package com.jk.controller;

import com.jk.entity.OrderEntity;
import com.jk.service.OrderService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrderController {
    @Resource
    private OrderService orderService;
    @RequestMapping("orderList")
    public List<OrderEntity> orderList(){
      return  orderService.orderList();
    }

    @RequestMapping("saveOrder")
    public void saveOrder(@RequestBody OrderEntity order){
        orderService.saveOrder(order);
    }
    @RequestMapping("findOrderOne")
    public OrderEntity findOrderOne(@RequestParam Integer orderId){
        return orderService.findOrderOne(orderId);
    }
    @RequestMapping("deleteOrderByIds")
    public void deleteOrderByIds(@RequestParam String[] orderIds){
        orderService.deleteOrderByIds(orderIds);
    }
}
