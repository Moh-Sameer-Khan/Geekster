package com.geekster.Restaurant._Management_Service_API.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,scope=FoodItem.class,property="foodItemId")
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodItemId;

    @NotNull(message = "Food Title can not be null")
    @Size(max = 100)
    private String foodItemTitle;

    @NotNull(message = "Food Description can not be null")
    private String foodItemDescription;

    @NotNull(message = "Food Price can not be null")
    @DecimalMin(value = "0.01", message = "Price must be greater than or equal to 0.01")
    private Long foodItemPrice;

    @NotNull(message = "Image url can not be null")
    private String foodItemDummyImageUrl;


//    We are using Bidirectional Mapping and Cascading also here
//    many to many mapping between FoodItem and order
    @ManyToMany(mappedBy = "foodItems")
    private List<Order> orders;
}
