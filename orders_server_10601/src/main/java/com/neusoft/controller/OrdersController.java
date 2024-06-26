package com.neusoft.controller;

import com.neusoft.po.CommonResult;
import com.neusoft.po.Orders;
import com.neusoft.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RefreshScope
@RestController
@RequestMapping("/")
public class OrdersController {
    @Autowired

    private OrdersService ordersService;

    @PostMapping("/OrdersId")
    public CommonResult<Integer> createOrders(Orders orders) throws Exception {
        return new CommonResult<>(200, "success", ordersService.createOrders(orders));
    }

    @GetMapping("/OrdersId")
    public CommonResult<Orders> getOrderById(Orders orders) throws Exception {
        return new CommonResult<>(200, "success", ordersService.getOrdersById(orders.getOrderId()));
    }

    @GetMapping("/UserId")
    public CommonResult<List> listOrdersByUserId(Orders orders) throws Exception {
        return new CommonResult<>(200, "success", ordersService.listOrdersByUserId(orders.getUserId()));
    }

    @PostMapping("/updateOrder")
    public CommonResult<Integer> updateOrder(Orders orders) throws Exception {
        return new CommonResult<>(200, "success", ordersService.updateOrder(orders.getOrderId(),orders.getOrderState()));
    }

    @PostMapping("/updateOrders")
    public CommonResult<Integer> updateOrders(Orders orders) throws Exception {
        return new CommonResult<>(200, "success", ordersService.updateOrders(orders.getOrderId(),orders.getOrderTotal()));
    }
}