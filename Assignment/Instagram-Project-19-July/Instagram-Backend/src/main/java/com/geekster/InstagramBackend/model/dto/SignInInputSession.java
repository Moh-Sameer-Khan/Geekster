package com.geekster.InstagramBackend.model.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInInputSession {

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@instauser\\.com$")
    private String userEmail;
    private String tokenValue;
}
