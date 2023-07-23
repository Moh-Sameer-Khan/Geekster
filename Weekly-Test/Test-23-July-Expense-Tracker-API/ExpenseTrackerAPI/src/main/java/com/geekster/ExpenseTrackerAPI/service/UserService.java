package com.geekster.ExpenseTrackerAPI.service;

import com.geekster.ExpenseTrackerAPI.entity.AuthenticationToken;
import com.geekster.ExpenseTrackerAPI.entity.Expense;
import com.geekster.ExpenseTrackerAPI.entity.User;
import com.geekster.ExpenseTrackerAPI.entity.dto.AuthInput;
import com.geekster.ExpenseTrackerAPI.entity.dto.SignInInput;
import com.geekster.ExpenseTrackerAPI.entity.dto.SignUpOutput;
import com.geekster.ExpenseTrackerAPI.repository.IUserRepo;
import com.geekster.ExpenseTrackerAPI.service.utility.email.utility.EmailHandler;
import com.geekster.ExpenseTrackerAPI.service.utility.hashingUtility.PasswordEncrypter;
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
    ExpenseService expenseService;

    public SignUpOutput userSignUp(User user) {

        boolean signUpStatus = true;
        String signUpStatusMessage = null;

        String newUserEmail = user.getUserEmail();
        String newUserUsername = user.getUsername();

        if(newUserEmail == null) {
            signUpStatus = false;
            signUpStatusMessage = "Invalid User Email!!!";
            return new SignUpOutput(signUpStatus, signUpStatusMessage);
        }
        if(newUserUsername == null) {
            signUpStatus = false;
            signUpStatusMessage = "Invalid User Username!!!";
            return new SignUpOutput(signUpStatus, signUpStatusMessage);
        }

//        check if this user email already exists ??
        User existingUser = iUserRepo.findFirstByUserEmail(newUserEmail);
        if(existingUser != null) {
            signUpStatus = false;
            signUpStatusMessage = "User Email Already Registered!!!";
            return new SignUpOutput(signUpStatus, signUpStatusMessage);
        }

//        hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(user.getUserPassword());

//      save the user with the new encrypted password
        user.setUserPassword(encryptedPassword);
        iUserRepo.save(user);
        return new SignUpOutput(signUpStatus, "User Registered Successfully!!!");

        } catch (Exception e) {
            signUpStatus = false;
            signUpStatusMessage = "Internal error occurred during sign up";
            return new SignUpOutput(signUpStatus, signUpStatusMessage);
        }
    }

    public String userSignIn(SignInInput signInInput) {

        String signInStatusMessage = null;

        String signInUsername = signInInput.getUserUsername();

        if(signInUsername == null) {
            signInStatusMessage = "Invalid User Username!!!";
            return signInStatusMessage;
        }

//        check if this user email already exists ??
        User existingUser = iUserRepo.findFirstByUsername(signInUsername);
        if(existingUser == null) {
            signInStatusMessage = "Sorry, User Not Registered!!!";
            return signInStatusMessage;
        }

//        match passwords :

//        hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getUserPassword());
            if(existingUser.getUserPassword().equals(encryptedPassword)) {
//                session should be created since password matched and user id is valid
                AuthenticationToken authToken = new AuthenticationToken(existingUser);
                authenticationService.saveAuthToken(authToken);

                EmailHandler.sendEmail("mskhanm1819@gmail.com", "Expenser Tracker Sign-In Testing!!", authToken.getTokenValue());
                return "Token Sent to your Email!!!";

            }else {
                signInStatusMessage = "Invalid credentials!!!";
                return signInStatusMessage;
            }
        } catch (NoSuchAlgorithmException e) {
            signInStatusMessage = "Internal error occurred during sign In";
            return signInStatusMessage;
        }
    }

    public void createExpense(Expense expense) {
        expenseService.saveExpense(expense);
    }

    public void userSignOut(AuthInput authInput) {
        String email = authInput.getEmail();
        User user = iUserRepo.findFirstByUserEmail(email);

        AuthenticationToken authToken = authenticationService.findFirstByUser(user);
        authenticationService.remove(authToken);

    }
}
