package com.geekster.InstagramBackend.service;

import com.geekster.InstagramBackend.model.AuthenticationToken;
import com.geekster.InstagramBackend.model.User;
import com.geekster.InstagramBackend.model.dto.SignInInputSession;
import com.geekster.InstagramBackend.repository.IAuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    IAuthRepo iAuthRepo;
    public void saveAuthToken(AuthenticationToken authToken) {
        iAuthRepo.save(authToken);
    }

    public boolean authenticate(SignInInputSession signInInputSession) {
        String authTokenValue = signInInputSession.getTokenValue();
        String authEmail = signInInputSession.getUserEmail();

        AuthenticationToken authToken = iAuthRepo.findFirstByTokenValue(authTokenValue);

        if(authToken == null) {
            return false;
        }

        String tokenConnectedEmail = authToken.getTokenOwner().getUserEmail();

        return tokenConnectedEmail.equals(authEmail);
    }

    public User findUser(String userUpdateToken) {
        AuthenticationToken authToken = iAuthRepo.findFirstByTokenValue(userUpdateToken);
        return authToken.getTokenOwner();
    }

    public boolean authenticateInsta(String email, String tokenValue) {

        AuthenticationToken authToken = iAuthRepo.findFirstByTokenValue(tokenValue);

        if(authToken == null) {
            return false;
        }

        String tokenConnectedEmail = authToken.getTokenOwner().getUserEmail();

        return tokenConnectedEmail.equals(email);

    }
}
