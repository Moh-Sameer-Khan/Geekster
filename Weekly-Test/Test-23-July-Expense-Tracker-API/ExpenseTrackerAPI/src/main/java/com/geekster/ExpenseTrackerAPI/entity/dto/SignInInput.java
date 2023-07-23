package com.geekster.ExpenseTrackerAPI.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInInput {


//    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@expuser\\.com$")
//    private String userEmail;

    @NotBlank(message = "Username is required")
    private String userUsername;
    private String userPassword;
}
