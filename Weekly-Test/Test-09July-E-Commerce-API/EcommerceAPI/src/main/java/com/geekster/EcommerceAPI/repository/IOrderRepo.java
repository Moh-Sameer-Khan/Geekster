package com.geekster.EcommerceAPI.repository;

import com.geekster.EcommerceAPI.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepo extends CrudRepository<Order, Integer> {
    @Query(value = "select * from Orders where order_id = :orderId", nativeQuery = true)
    Order getOrderById(Integer orderId);
}
