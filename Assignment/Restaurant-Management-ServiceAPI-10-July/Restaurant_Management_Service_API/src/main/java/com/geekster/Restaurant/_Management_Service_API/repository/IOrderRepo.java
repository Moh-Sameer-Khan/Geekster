package com.geekster.Restaurant._Management_Service_API.repository;

import com.geekster.Restaurant._Management_Service_API.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepo extends CrudRepository<Order, Long> {
}
