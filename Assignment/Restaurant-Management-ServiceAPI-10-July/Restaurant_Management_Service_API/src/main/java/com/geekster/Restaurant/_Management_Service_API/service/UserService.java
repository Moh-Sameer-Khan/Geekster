package com.geekster.Restaurant._Management_Service_API.service;

import com.geekster.Restaurant._Management_Service_API.model.AuthenticationToken;
import com.geekster.Restaurant._Management_Service_API.model.Order;
import com.geekster.Restaurant._Management_Service_API.model.User;
import com.geekster.Restaurant._Management_Service_API.model.dto.SignInInput;
import com.geekster.Restaurant._Management_Service_API.model.dto.SignUpOutput;
import com.geekster.Restaurant._Management_Service_API.repository.IAuthRepo;
import com.geekster.Restaurant._Management_Service_API.repository.IUserRepo;
import com.geekster.Restaurant._Management_Service_API.service.utility.emailUtility.EmailHandler;
import com.geekster.Restaurant._Management_Service_API.service.utility.hashingUtility.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    IUserRepo iUserRepo;

    @Autowired
    IAuthRepo iAuthRepo;

    @Autowired
    OrderService orderService;

    public SignUpOutput signUpUser(User user) {

        boolean signUpStatus = true;
        String signUpStatusMessage = null;

        String newUserEmail = user.getUserEmail();

        if(newUserEmail == null) {
            signUpStatus = false;
            signUpStatusMessage = "Invalid User Email!!!";
            return new SignUpOutput(signUpStatus, signUpStatusMessage);
        }

        //check if this user email already exists ??
        User existingUser = iUserRepo.findFirstByUserEmail(newUserEmail);

        if(existingUser != null) {
            signUpStatus = false;
            signUpStatusMessage = "User Email Already Registered!!!";

            return new SignUpOutput(signUpStatus, signUpStatusMessage);
        }

        //hash the password: encrypt the password
        try{
            String encryptedPassword = PasswordEncrypter.encryptPassword(user.getUserPassword());
            //save  the user with the new encrypted password
            user.setUserPassword(encryptedPassword);
            iUserRepo.save(user);
            return new SignUpOutput(signUpStatus, "User Registered Successfully!!!");
        }
        catch(Exception ee) {
            signUpStatus = false;
            signUpStatusMessage = "Internal error occurred during sign up";
            return new SignUpOutput(signUpStatus, signUpStatusMessage);
        }

    }

    public String signInUser(SignInInput signInInput) {

        String signInStatusMessage = null;

        String newSignInEmail = signInInput.getEmail();
        if(newSignInEmail == null)
        {
            signInStatusMessage = "Invalid User email";
            return signInStatusMessage;
        }

        //check if this patient email already exists ??
        User existingUser = iUserRepo.findFirstByUserEmail(newSignInEmail);
        if(existingUser == null) {
            signInStatusMessage = "User Email not registered!!!";
            return signInStatusMessage;
        }
        //match passwords :

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getPassword());
//          matching password
            if(existingUser.getUserPassword().equals(encryptedPassword)) {
//                //session should be created since password matched and user id is valid
                AuthenticationToken authToken = new AuthenticationToken(existingUser);
                iAuthRepo.save(authToken);

                EmailHandler.sendEmail("mskhanm1819@gmail.com", "Email Sign-In testing..", authToken.getTokenValue());
                return "Token Sent To your Eamil Successfully";
            }else  {
                signInStatusMessage = "Invalid credentials!!!";
                return signInStatusMessage;
            }
        } catch (Exception e) {
            signInStatusMessage = "Internal error occurred during sign in";
            return signInStatusMessage;
        }
    }

    public List<User> getAllUsers() {
        return iUserRepo.findAll();
    }

    public String signOutUser(String email) {
        User user = iUserRepo.findFirstByUserEmail(email);
        iAuthRepo.delete(iAuthRepo.findFirstByUserAuthToken(user));
        return "User Signed Out Successfully!!!";
    }

    public boolean addOrder(Order order) {
//        id of user
        Long userId = order.getUser().getUserId();
        boolean isUserValid = iUserRepo.existsById(userId);
        if(isUserValid) {
            orderService.saveOrder(order);
            return true;
        }else {
            return false;
        }
    }
}
