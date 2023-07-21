package com.geekster.UserManagement.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {


    @NotNull // this data member can not be null
    private Integer userId;
    @NotBlank(message = "name cannot be blank") // it can not blank should be one character not space
    private String userName;
    @Email(message = "Given email id is invalid")  //something@something
    private String userEmail;
    @Pattern(regexp = "^(?=.*[!@#$%^&*()\\[\\]{};':\"\\\\|,.<>/?])(?=.*\\d)(?=.*[A-Z]).{6,}$")
    private String password;
    @Size(min = 7, max = 10) // it can be on string ,size
    @Pattern(regexp = "^[0-9]+$")
    private String userContact;
    @Min(value = 18)
    @Max(value = 30)
    private Integer userAge;
//    @NotNull
    private LocalDate userDOB;  //EX : 2007-12-03.
    private Type userType;

}
