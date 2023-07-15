package com.geekster.Restaurant._Management_Service_API.repository;

import com.geekster.Restaurant._Management_Service_API.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoodItemRepo extends JpaRepository<FoodItem, Long> {

}
