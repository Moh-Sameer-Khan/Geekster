package com.geekster.ExpenseTrackerAPI.service;

import com.geekster.ExpenseTrackerAPI.entity.AuthenticationToken;
import com.geekster.ExpenseTrackerAPI.entity.User;
import com.geekster.ExpenseTrackerAPI.entity.dto.AuthInput;
import com.geekster.ExpenseTrackerAPI.repository.IAuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    IAuthRepo iAuthRepo;


    public void saveAuthToken(AuthenticationToken authToken) {
        iAuthRepo.save(authToken);
    }

    public boolean authenticate(String email, String tokenValue) {
        AuthenticationToken authToken = iAuthRepo.findFirstByTokenValue(tokenValue);

        if(authToken == null) {
            return false;
        }
        String tokenConnectedEmail = authToken.getTokenOwner().getUserEmail();
        return tokenConnectedEmail.equals(email);
    }

    public boolean authenticateUser(AuthInput authInput) {
        String newTokenValue = authInput.getToken();
        AuthenticationToken authToken = iAuthRepo.findFirstByTokenValue(newTokenValue);

        if(authToken == null) {
            return false;
        }
        String tokenConnectedEmail = authToken.getTokenOwner().getUserEmail();
        return tokenConnectedEmail.equals(authInput.getEmail());
    }

    public AuthenticationToken findFirstByUser(User user) {
        return iAuthRepo.findFirstByTokenOwner(user);
    }

    public void remove(AuthenticationToken authToken) {
        iAuthRepo.delete(authToken);
    }
}
