package com.geekster.EmployeeAddress.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // creating a table of this class
public class Employee {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatic Generate a value for id
    private Long empId;
    private String empFirstName;
    private String empLastName;


//    this class/ table we are taking an Owner side so, we will make Foreign key in this class and mapping
//    we are adding a new column in this table not directly but indirectly adding a column
//    @OneToOne(cascade = CascadeType.ALL) // Type of mapping // Just practice of cascading // now we can add any table add first both are independent bcz cascade changing the data of address table bot not pass id otherwise error
    @OneToOne // now employee table is dependent from the address table so, first we add address table later employee table carefully on
    @JoinColumn(name = "fk_addressId")
    private Address address;
}
