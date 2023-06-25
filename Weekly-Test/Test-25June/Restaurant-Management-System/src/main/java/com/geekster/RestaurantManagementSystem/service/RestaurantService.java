package com.geekster.RestaurantManagementSystem.service;

import com.geekster.RestaurantManagementSystem.model.Restaurant;
import com.geekster.RestaurantManagementSystem.model.Specialty;
import com.geekster.RestaurantManagementSystem.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepo restaurantRepo;

    public List<Restaurant> getAllRestaurantsList() {
        return restaurantRepo.getAllRestaurantsList();
    }

    public String addRestaurants(List<Restaurant> restaurants) {
//        we need a list where we all add these are restaurants list
        List<Restaurant> restaurantList = getAllRestaurantsList();
//        for(Restaurant restaurant : restaurants) {
//            restaurantList.add(restaurant);
//        }
//        or we can add direct one list to another list by a method
        restaurantList.addAll(restaurants);
        return "Restaurants Added Successfully!!!";
    }

    public Restaurant getRestaurantsById(Integer restId) {
//        we need a list where we all find the matching restaurant who giving the id
        List<Restaurant> restaurantList = getAllRestaurantsList();
        for(Restaurant restaurant : restaurantList) {
            if(restaurant.getRestaurantId().equals(restId)) {
                return  restaurant;
            }
        }
//        if suppose that id is not in restaurant list then we will handle it
        return null;
    }

    public String updateRestaurantInformation(Integer restroId, Specialty specialty) {
        List<Restaurant> restaurantList = getAllRestaurantsList();
        for(Restaurant restaurant : restaurantList) {
            if(restaurant.getRestaurantId().equals(restroId)) {
                restaurant.setRestaurantSpecialty(specialty);
                return "Specialty for ID : " + restroId + " updated Successfully";
            }
        }
        return "Specialty for ID : " + restroId + " not updated because it's does not exist in List";
    }

    public String deleteRestaurantsById(Integer restroId) {
        List<Restaurant> restaurantList = getAllRestaurantsList();
        for(Restaurant restaurant : restaurantList) {
            if(restaurant.getRestaurantId().equals(restroId)) {
                restaurantList.remove(restaurant);
                return "Restaurants for ID: " + restroId + " Deleted Successfully";
            }
        }
        return "Restaurants for ID : " + restroId + " not Deleted because it's does not exist in List";
    }
}
