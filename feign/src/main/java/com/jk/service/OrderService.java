package com.jk.service;

import com.jk.entity.OrderEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value="order-provider")
public interface OrderService {
    @RequestMapping("orderList")
    public List<OrderEntity> orderList();

    @RequestMapping("saveOrder")
    public void saveOrder(@RequestBody OrderEntity order);

    @RequestMapping("findOrderOne")
    public OrderEntity findOrderOne(@RequestParam Integer orderId);

    @RequestMapping("deleteOrderByIds")
    public void deleteOrderByIds(@RequestParam String[] orderIds);
}
