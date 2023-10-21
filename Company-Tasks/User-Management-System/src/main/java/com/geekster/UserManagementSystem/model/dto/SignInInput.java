package com.geekster.UserManagementSystem.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInInput {

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@user\\.com$")
    private String email;

    @NotBlank(message = "Password is Required")
    private String password;
}
