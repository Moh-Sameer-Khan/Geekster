package com.geekster.RestaurantManagementSystem.controller;

import com.geekster.RestaurantManagementSystem.model.Restaurant;
import com.geekster.RestaurantManagementSystem.model.Specialty;
import com.geekster.RestaurantManagementSystem.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;


//    Task -- 1 --> Get All Restaurant using GetMapping
    @GetMapping("restaurants")
    public List<Restaurant> getAllRestaurant() {
        return restaurantService.getAllRestaurantsList();
    }

//    Task -- 2 --> Add some Restaurant to Restaurant lists using PostMapping
    @PostMapping("restaurants/add")
    public String addRestaurants(@RequestBody List<Restaurant> restaurants) {
        return restaurantService.addRestaurants(restaurants);
    }

//    Task -- 3 --> Get Restaurant By id using GetMapping
    @GetMapping("restaurants/{restId}")
    public Restaurant getRestaurantsById(@PathVariable Integer restId) {
        return restaurantService.getRestaurantsById(restId);
    }

//    Task -- 4 --> Update Restaurant information like Specialty
    @PutMapping("restaurants/update/{restroId}/{specialty}")
    public String updateRestaurantInformation(@PathVariable Integer restroId, @PathVariable Specialty specialty) {
        return restaurantService.updateRestaurantInformation(restroId, specialty);
    }
//    Task -- 5 --> Delete Restaurant from the list
    @DeleteMapping("restaurants/delete/{restroId}")
    public String deleteRestaurantsById(@PathVariable Integer restroId) {
        return restaurantService.deleteRestaurantsById(restroId);
    }

//    My Weekly Test completed till here
//    Below I'm Adding my Extra Operation to perform restaurant different --2 types
//    Task -- 6 -->
//    Task -- 7 -->
//    Task -- 8 -->
//    Task -- 9 -->
//    Task -- 10 -->
//    Task -- 11-->

}
