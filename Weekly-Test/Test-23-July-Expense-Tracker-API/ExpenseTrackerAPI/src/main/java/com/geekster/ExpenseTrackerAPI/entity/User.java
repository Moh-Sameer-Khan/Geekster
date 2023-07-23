package com.geekster.ExpenseTrackerAPI.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank(message = "User First Name can not be blank")
    private String userFirstName;


    private String userLastName;

    private Integer userAge;

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@expuser\\.com$")
    private String userEmail;

    @NotBlank(message = "Username is required")
    @Column(unique = true)
    private String username;

    @NotBlank(message = "Password is required")
    private String userPassword;
}
