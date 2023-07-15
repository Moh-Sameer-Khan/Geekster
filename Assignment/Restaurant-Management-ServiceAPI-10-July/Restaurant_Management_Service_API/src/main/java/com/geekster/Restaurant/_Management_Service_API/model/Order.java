package com.geekster.Restaurant._Management_Service_API.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,scope=Order.class,property="orderId")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

//    @NotBlank(message = "Order ID is required")
//    private String orderID;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be greater than or equal to 1")
    private Integer orderQuantity;

//    I will use Bidirectional Mapping And cascading also in this Project
//    Many-To-One mapping between Order(Many) and User(One)
    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

//    Many To Many mapping between Order(many) and FoodItem(many)
    @ManyToMany
    @JoinTable(name = "fk_order_fooditem_table", joinColumns = @JoinColumn(name = "fk_order_id"), inverseJoinColumns = @JoinColumn(name = "fk_fooditem_id"))
    private List<FoodItem> foodItems;

//    Enum Class
    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime orderTimeStamp;

}
