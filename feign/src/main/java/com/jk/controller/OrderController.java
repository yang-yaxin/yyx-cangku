package com.jk.controller;

import com.jk.entity.OrderEntity;
import com.jk.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class OrderController {
    @Resource
    private OrderService orderService;
    @RequestMapping("index")
    public String orderIndex(){

        return "order";
    }
    @RequestMapping("orderList")
    @ResponseBody
    public List<OrderEntity> orderList(){
        return  orderService.orderList();
    }

    @RequestMapping("saveOrder")
    @ResponseBody
    public void saveOrder(OrderEntity order){
        orderService.saveOrder(order);
    }
    @RequestMapping("findOrderOne")
    @ResponseBody
    public OrderEntity findOrderOne(Integer orderId){
        return orderService.findOrderOne(orderId);
    }
    @RequestMapping("deleteOrderByIds")
    @ResponseBody
    public void deleteOrderByIds(String[] orderIds){
        orderService.deleteOrderByIds(orderIds);
    }

}
