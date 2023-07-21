package com.geekster.InstagramBackend.service;

import com.geekster.InstagramBackend.model.AuthenticationToken;
import com.geekster.InstagramBackend.model.User;
import com.geekster.InstagramBackend.model.dto.SignInInput;
import com.geekster.InstagramBackend.model.dto.SignInInputSession;
import com.geekster.InstagramBackend.model.dto.SignUpOutput;
import com.geekster.InstagramBackend.repository.IAuthRepo;
import com.geekster.InstagramBackend.repository.IUserRepo;
import com.geekster.InstagramBackend.service.utility.emailUtility.EmailHandler;
import com.geekster.InstagramBackend.service.utility.hashingUtility.PasswordEncrypter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    @Autowired
    IUserRepo iUserRepo;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    IAuthRepo iAuthRepo;

    public SignUpOutput userSignUp(User user) {

        boolean signUpStatus = true;
        String signUpStatusMessage = null;

        String newUserEmail = user.getUserEmail();
        if(newUserEmail == null) {
            signUpStatus = false;
            signUpStatusMessage = "Invalid User Email";
            return new SignUpOutput(signUpStatus, signUpStatusMessage);
        }

//        check if this user email already exists ??
        User existingUser = iUserRepo.findFirstByUserEmail(newUserEmail);
        if(existingUser != null) {
            signUpStatus = false;
            signUpStatusMessage = "User Email Already Registered!!";

            return new SignUpOutput(signUpStatus, signUpStatusMessage);
        }

//        hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(user.getUserPassword());

            //save the user with the new encrypted password
            user.setUserPassword(encryptedPassword);
            iUserRepo.save(user);

            return new SignUpOutput(signUpStatus, "User Registered Successfully!!!");
        } catch (Exception e) {
            signUpStatus = false;
            signUpStatusMessage = "Internal error occurred during sign up";

            return new SignUpOutput(signUpStatus, signUpStatusMessage);

        }
    }

    public String signInInstaUser(SignInInput signInInput) {

        String signInStatusMessage = null;

        String signInEmail = signInInput.getUserEmail();
        if(signInEmail == null) {
            signInStatusMessage = "Invalid Email!!!";
            return  signInStatusMessage;
        }

//      check if this user email already exists ??
        User existingUser = iUserRepo.findFirstByUserEmail(signInEmail);
        if(existingUser == null) {
            signInStatusMessage = "User Email Not Registered!!!";
            return signInStatusMessage;
        }

//        match passwords :

//        hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getUserPassword());

            if(existingUser.getUserPassword().equals(encryptedPassword)) {
                //session should be created since password matched and user id is valid
                AuthenticationToken authToken = new AuthenticationToken(existingUser);
                authenticationService.saveAuthToken(authToken);

                EmailHandler.sendEmail("mskhanm1819@gmail.com", " Instagram Sign In Testing", authToken.getTokenValue());
                return "Token Sent to Your Email!!!";
            }
            else {
                signInStatusMessage = "Invalid credentials!!!";
                return signInStatusMessage;
            }
        } catch (Exception e) {
            signInStatusMessage = "Internal error occurred during sign up";
            return signInStatusMessage;
        }
    }

    public void updateInstaInformation(User user, SignInInputSession signInInputSession) {

        String userUpdateToken = signInInputSession.getTokenValue();
        User existingUser = authenticationService.findUser(userUpdateToken);

        if(user.getUserFirstName().length() != 0 || user.getUserFirstName() != null) {
            existingUser.setUserFirstName(user.getUserFirstName());
        }

        if(user.getUserLastName().length() != 0 || user.getUserLastName() != null) {
            existingUser.setUserLastName(user.getUserLastName());
        }

        if(user.getUserAge() != null) {
            existingUser.setUserAge(user.getUserAge());
        }

        if(user.getUserPassword().length() != 0 || user.getUserPassword() != null) {
            try {
                String encryptedPassword = PasswordEncrypter.encryptPassword(user.getUserPassword());
                existingUser.setUserPassword(encryptedPassword);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }

        }

        if(user.getUserContactNumber().length() != 0 || user.getUserContactNumber() != null) {
            existingUser.setUserContactNumber(user.getUserContactNumber());
        }

        if(user.getAccountType().name().length() != 0 || user.getAccountType() != null) {  // it can set without this because this is enum
            existingUser.setAccountType(user.getAccountType());
        }
        if(user.getGender().name().length() != 0 || user.getGender() != null) {
            existingUser.setGender(user.getGender());
        }
        if(user.getUserEmail().length() != 0 || user.getUserEmail() != null) {
            existingUser.setUserEmail(user.getUserEmail());
        }

        if(!(user.isBlueTick())) {
            existingUser.setBlueTick(true);
        }
        iUserRepo.save(existingUser);
    }
}
