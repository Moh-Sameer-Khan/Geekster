package com.geekster.EcommerceAPI.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    private String productName;

    private Integer productPrice;

    private String productDescription;

    @Enumerated(EnumType.STRING)
    private Category productCategory;

    @Enumerated(EnumType.STRING)
    private Brand productBrand;
}
