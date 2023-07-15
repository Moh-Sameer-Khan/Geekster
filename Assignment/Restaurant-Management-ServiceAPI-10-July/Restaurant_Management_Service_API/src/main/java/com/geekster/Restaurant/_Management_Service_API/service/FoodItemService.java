package com.geekster.Restaurant._Management_Service_API.service;

import com.geekster.Restaurant._Management_Service_API.model.FoodItem;
import com.geekster.Restaurant._Management_Service_API.repository.IFoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodItemService {
    @Autowired
    IFoodItemRepo iFoodItemRepo;

    public String addFoodItems(FoodItem foodItem) {
        iFoodItemRepo.save(foodItem);
        return "FoodItem Added Successfully";
    }
}
