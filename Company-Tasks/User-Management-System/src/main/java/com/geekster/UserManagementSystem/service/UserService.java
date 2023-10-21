package com.geekster.UserManagementSystem.service;

import com.geekster.UserManagementSystem.model.AuthenticationToken;
import com.geekster.UserManagementSystem.model.User;
import com.geekster.UserManagementSystem.model.dto.SignInInput;
import com.geekster.UserManagementSystem.model.dto.SignUpOutput;
import com.geekster.UserManagementSystem.repository.IUserRepo;
import com.geekster.UserManagementSystem.service.utility.emailUtility.EmailHandler;
import com.geekster.UserManagementSystem.service.utility.hashingUtiltity.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserRepo iUserRepo;

    @Autowired
    private AuthenticationService authenticationService;


    public SignUpOutput signUpUser(User user) {

        boolean signUpStatus = true;
        String signUpStatusMessage = null;

        String newEmail = user.getUserEmail();

        if(newEmail == null)
        {
            signUpStatusMessage = "Invalid User email!!!";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

        //check if this user email already exists ??
        User exitingUser = iUserRepo.findFirstByUserEmail(newEmail);
        if(exitingUser != null) {
            signUpStatusMessage = "Email already registered!!!";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

        //hash the password: encrypt the password

        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(user.getUserPassword());

            //save  the user with the new encrypted password
            user.setUserPassword(encryptedPassword);
            iUserRepo.save(user);

            return new SignUpOutput(signUpStatus, "User registered successfully!!!");
        } catch (Exception e) {
            signUpStatusMessage = "Internal error occurred during User Sign Up!!!";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }
    }

    public String sigInUser(SignInInput signInInput) {

        String signInStatusMessage = null;

        String signInEmail = signInInput.getEmail();

        if(signInEmail == null)
        {
            signInStatusMessage = "Invalid User email!!!";
            return signInStatusMessage;
        }

        //check if this user email already exists ??
        User existingUser = iUserRepo.findFirstByUserEmail(signInEmail);

        if(existingUser == null)
        {
            signInStatusMessage = "Email not registered!!!";
            return signInStatusMessage;
        }

        //match passwords :

        //hash the password: encrypt the password

        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getPassword());

            if(existingUser.getUserPassword().equals(encryptedPassword)) {
                //session should be created since password matched and user id is valid
                AuthenticationToken authToken = new AuthenticationToken(existingUser);
                authenticationService.saveAuthToken(authToken);

//                now I Want to send OTP on Email --> Email Integration
                EmailHandler.sendEMail("mskhanm1819@gmail.com", "User Sign-In Testing!!!", authToken.getTokenValue());;

                return "Token Sent to your Email!!!";

            }else {
                signInStatusMessage = "Invalid credentials!!!";
                return signInStatusMessage;
            }

        } catch (Exception e) {
            signInStatusMessage = "Internal error occurred during sign in";
            return signInStatusMessage;
        }

    }

    public User getUser(String email) {
        return iUserRepo.findByUserEmail(email);
    }

    public String updateUserInfo(String email, User newUser) {
        User existUser = iUserRepo.findFirstByUserEmail(email);

        if(existUser != null && newUser != null) {
            existUser.setUserBio(newUser.getUserBio());
            existUser.setUserHandle(newUser.getUserHandle());
            existUser.setGender(newUser.getGender());
            existUser.setUserEmail(newUser.getUserEmail());

            iUserRepo.save(existUser);
            return "User Information Updated Successfully!!!";
        }else {
            return "Sorry, Updated ...Not allowed for invalid information!!!!";
        }
    }
}
