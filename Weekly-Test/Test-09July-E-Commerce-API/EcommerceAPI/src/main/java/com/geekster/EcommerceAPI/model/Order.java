package com.geekster.EcommerceAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

//  Many-to-one mapping between order to user
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id")
    private User user;

//    Many-to-Many mapping between Product and Order
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "fk_order_product_table", joinColumns = @JoinColumn(name = "fk_order_id"), inverseJoinColumns = @JoinColumn(name = "fk_product_id"))
    private List<Product> products;

//    Many-to-one relation between Order and address
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_address_id")
    private Address address;

    private Integer productQuantity;
}
