package com.geekster.EcommerceAPI.service;

import com.geekster.EcommerceAPI.model.Order;
import com.geekster.EcommerceAPI.repository.IOrderRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    IOrderRepo iOrderRepo;

    public String addOrders(Order order) {
        iOrderRepo.save(order);
        return "Order Added Successfully!!!!";
    }


    public Order getOrderById(Integer orderId) {
        return iOrderRepo.getOrderById(orderId);
    }
}
