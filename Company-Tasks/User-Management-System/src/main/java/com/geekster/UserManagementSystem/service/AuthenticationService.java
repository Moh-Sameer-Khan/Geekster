package com.geekster.UserManagementSystem.service;

import com.geekster.UserManagementSystem.model.AuthenticationToken;
import com.geekster.UserManagementSystem.repository.IAuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private IAuthRepo iAuthRepo;
    public void saveAuthToken(AuthenticationToken authToken) {
        iAuthRepo.save(authToken);
    }

    public boolean authenticate(String email, String tokenValue) {
        AuthenticationToken authToken = iAuthRepo.findFirstByTokenValue(tokenValue);

        if(authToken == null)
        {
            return false;
        }

        String tokenConnectedEmail = authToken.getTokenOwner().getUserEmail();
        return tokenConnectedEmail.equals(email);
    }
}
