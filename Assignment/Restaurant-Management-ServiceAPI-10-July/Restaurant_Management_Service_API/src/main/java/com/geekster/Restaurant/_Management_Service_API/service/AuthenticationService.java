package com.geekster.Restaurant._Management_Service_API.service;

import com.geekster.Restaurant._Management_Service_API.model.AuthenticationToken;
import com.geekster.Restaurant._Management_Service_API.repository.IAuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    IAuthRepo iAuthRepo;

    public boolean authenticate(String email, String authTokenValue) {
        AuthenticationToken authToken = iAuthRepo.findFirstByTokenValue(authTokenValue);
        if(authToken == null) {
            return false;
        }
        String tokenConnectedEmail = authToken.getUserAuthToken().getUserEmail();
        return tokenConnectedEmail.equals(email);
    }
}
