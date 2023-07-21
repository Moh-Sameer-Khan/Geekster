package com.geekster.InstagramBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.geekster.InstagramBackend.model.enums.AccountType;
import com.geekster.InstagramBackend.model.enums.Gender;
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

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@instauser\\.com$")
    private String userEmail;

    @NotBlank(message = "User Contact number can not be blank")
    private String userContactNumber;

    @NotBlank(message = "User Password can not be blank")
    private String userPassword;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // hide this in json but not in database table column
    private boolean blueTick;
}
