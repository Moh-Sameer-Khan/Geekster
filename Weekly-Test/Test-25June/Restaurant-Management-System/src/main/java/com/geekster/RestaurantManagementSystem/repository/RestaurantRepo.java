package com.geekster.RestaurantManagementSystem.repository;

import com.geekster.RestaurantManagementSystem.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestaurantRepo {
    @Autowired
    List<Restaurant> restaurantList;

    public List<Restaurant> getAllRestaurantsList() {
        return restaurantList;
    }
}
