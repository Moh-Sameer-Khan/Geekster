package com.geekster.ExpenseTrackerAPI.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AuthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;

//    @NotBlank
    private String tokenValue;

    //    @NotBlank // if we are using this then error on exception during sign in
    private LocalDateTime tokenCreationDateTime;

//    Mapping
    @OneToOne
    @JoinColumn(name = "fk_token_user_id")
    private User tokenOwner;

    //create a parameterized constructor which takes user as an argument
    public AuthenticationToken(User existingUser) {
        this.tokenOwner = existingUser;
        this.tokenValue = UUID.randomUUID().toString();
        this.tokenCreationDateTime = LocalDateTime.now();
    }
}
