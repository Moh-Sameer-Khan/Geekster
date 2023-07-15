package com.geekster.Restaurant._Management_Service_API.controller;

import com.geekster.Restaurant._Management_Service_API.model.FoodItem;
import com.geekster.Restaurant._Management_Service_API.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodItemController {
    @Autowired
    FoodItemService foodItemService;

//      Task -- 1 --> add FoodItem // Post/CREATE // Using Custom Repository(CR) Method
    @PostMapping("foodItems")
    public String addFoodItems(@RequestBody FoodItem foodItem) {
        return foodItemService.addFoodItems(foodItem);
    }
}
