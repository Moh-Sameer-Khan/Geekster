package com.geekster.Restaurant._Management_Service_API.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,scope=User.class,property="userId")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Pattern(regexp = "^(?=.*[!@#$%^&*])(?=.{5,})[a-zA-Z0-9!@#$%^&*]+$", message = "Username is not valid Please check once...")
    private String userUserName;

//    @Pattern(regexp = "^(?=.*[!@#$%^&*])(?=.*[A-Z])(?=.{5,})[a-zA-Z0-9!@#$%^&*]+$", message = "Your Password is not valid Please check once....")
//    if we are using regexp then hash code password not working // throw an exception
    private String userPassword;

    @Pattern(regexp = "\\b[A-Za-z0-9._%+-]+@gmail\\.com\\b")
    private String userEmail;

//    Enum Class
    @Enumerated(EnumType.STRING)
    private Type userType;

//    we are using BiDirectional Mapping
//    one to Many Mapping between user(one) and Order(many)
    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}
