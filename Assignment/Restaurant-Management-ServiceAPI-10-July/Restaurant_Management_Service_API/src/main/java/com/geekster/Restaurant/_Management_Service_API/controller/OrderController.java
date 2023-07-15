package com.geekster.Restaurant._Management_Service_API.controller;

import com.geekster.Restaurant._Management_Service_API.model.FoodItem;
import com.geekster.Restaurant._Management_Service_API.model.Order;
import com.geekster.Restaurant._Management_Service_API.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

//    Task -- 1 --> add Order // Post/CREATE // Using Custom Repository(CR) Method
    @PostMapping("orders")
    public String addOrders(@RequestBody Order order) {
        return orderService.addOrders(order);
    }
}
