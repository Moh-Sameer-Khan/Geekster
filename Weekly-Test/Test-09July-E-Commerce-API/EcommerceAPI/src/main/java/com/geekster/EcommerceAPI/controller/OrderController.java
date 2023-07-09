package com.geekster.EcommerceAPI.controller;

import com.geekster.EcommerceAPI.model.Order;
import com.geekster.EcommerceAPI.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    //    Task -- 1 -- Create Order --> Crud Repository (CR) method
    @PostMapping("orders")
    public String addOrders(@RequestBody Order order) {
        return orderService.addOrders(order);
    }

//    Task -- 2 -> Get Order by Order_id //GET // I will get by Custom Query
    @GetMapping("orders/orderId/{orderId}")
    public Order getOrderById(@PathVariable Integer orderId) {
        return orderService.getOrderById(orderId);
    }
}
