package com.geekster.RestaurantManagementSystem.beanFactory;

import com.geekster.RestaurantManagementSystem.model.Restaurant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class configuration {
    @Bean
    public List<Restaurant> getAllRestaurans() {
        return new ArrayList<>();
    }
}
