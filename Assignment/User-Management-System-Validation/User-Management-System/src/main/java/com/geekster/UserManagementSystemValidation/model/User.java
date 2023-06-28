package com.geekster.UserManagementSystemValidation.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotNull // Use id should not be null
    private Integer userId;
    @NotBlank(message = "UserName can not be Blank")
    private String userName;

//    @NotBlank(message = "Date of Birth can not be Blank")
//    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
//    for LocalDate --> Validation not works so, I'm taking as a string
//    private LocalDate userDOB;
    @NotBlank(message = "Date of Birth can not be Blank") // bcz it's work for blank so used this
    @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}", message = "Date of Birth should be in dd-mm-yyyy format")
    private String userDOB;

    @NotBlank(message = "Email can not be blank") // bcz it's pass for blank so used this
    @Email(message = "Invalid Email Format")
    private String userEmail;

    @Size(min = 12, max = 12, message = "Phone number should be 12 digits long")
    @Pattern(regexp = "^\\d{2}\\d{10}$", message = "Invalid Phone Number format") // now it will work only number otherwise it's take the alphabets also
    private String phoneNumber;

//    not need Validation bcz it's enum
    private Type userType;
//
//    @NotBlank(message = "Date is Required")
//    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date should be in yyyy-MM-dd format")
    private LocalDate userCreateDate; // it's take the current date if I will use LocalDate.now()
    private LocalTime userCreatTime;// it's take the current time if I will use LocalTime.now()
//    if I want to use our choice date or time then use LocalDate.of(yyyy, mm, dd) like that any format
}
