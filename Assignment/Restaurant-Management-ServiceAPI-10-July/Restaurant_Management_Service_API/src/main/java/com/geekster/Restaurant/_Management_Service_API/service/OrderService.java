package com.geekster.Restaurant._Management_Service_API.service;

import com.geekster.Restaurant._Management_Service_API.model.Order;
import com.geekster.Restaurant._Management_Service_API.repository.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    IOrderRepo iOrderRepo;

    public String addOrders(Order order) {
        iOrderRepo.save(order);
        return "Order Added Successfully";
    }
}
