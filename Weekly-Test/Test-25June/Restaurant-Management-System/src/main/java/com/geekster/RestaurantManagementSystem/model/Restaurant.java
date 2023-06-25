package com.geekster.RestaurantManagementSystem.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
//    what we need in restaurant here are showing these all properties . .
//    Constructor, Getter and setter made by lombok dependency and using Annotation
    private Integer restaurantId;
    private String restaurantName;
    private String restaurantAddress;
    private String restaurantContactNumber;
    private Specialty restaurantSpecialty;
    private Integer restaurantTotalStaff;

//    private List<String> restaurantsMenuItems;
    private boolean restaurantOpen;
    private Integer restaurantRating;

}
