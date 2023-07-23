package com.geekster.ExpenseTrackerAPI.entity.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthInput {

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@expuser\\.com$")
    private String email;

    private String token;
}
