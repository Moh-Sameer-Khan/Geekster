package com.geekster.Restaurant._Management_Service_API.model.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInInput {

    @Pattern(regexp = "\\b[A-Za-z0-9._%+-]+@gmail\\.com\\b")
    private String email;
    private String password;
}
