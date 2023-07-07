package com.geekster.EmployeeAddress.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {

//    This class / table we are taking as Reference side
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addId;
    private String addStreet;
    private String city;
    private String state;
    private String addZipCode;
}
