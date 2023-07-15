package com.geekster.Restaurant._Management_Service_API.model;

import jakarta.persistence.*;
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
    private String tokenValue;
    private LocalDateTime tokenCreationDateTime;

//    mapping
    @OneToOne
    @JoinColumn(name = "fk_user_id")
    private User userAuthToken;

    @OneToOne
    @JoinColumn(name = "fk_admin_id")
    private Admin adminAuthToken;


    //create a parameterized constructor which takes User as an argument
    public AuthenticationToken(User existingUser) {
        this.userAuthToken = existingUser;
        this.tokenValue = UUID.randomUUID().toString();
        this.tokenCreationDateTime = LocalDateTime.now();
    }


    public AuthenticationToken(Admin existingAdmin) {
        this.adminAuthToken = existingAdmin;
        this.tokenValue = UUID.randomUUID().toString();
        this.tokenCreationDateTime = LocalDateTime.now();
    }
}
