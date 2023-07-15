package com.geekster.Restaurant._Management_Service_API.service;

import com.geekster.Restaurant._Management_Service_API.model.Admin;
import com.geekster.Restaurant._Management_Service_API.model.AuthenticationToken;
import com.geekster.Restaurant._Management_Service_API.model.User;
import com.geekster.Restaurant._Management_Service_API.model.dto.SignInInput;
import com.geekster.Restaurant._Management_Service_API.model.dto.SignUpOutput;
import com.geekster.Restaurant._Management_Service_API.repository.IAdminRepo;
import com.geekster.Restaurant._Management_Service_API.repository.IAuthRepo;
import com.geekster.Restaurant._Management_Service_API.service.utility.emailUtility.EmailHandler;
import com.geekster.Restaurant._Management_Service_API.service.utility.hashingUtility.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    IAdminRepo iAdminRepo;

    @Autowired
    IAuthRepo iAuthRepo;

    public SignUpOutput signUpAdmin(Admin admin) {

            boolean signUpStatus = true;
            String signUpStatusMessage = null;

            String newAdminEmail = admin.getAdminEmail();

            if(newAdminEmail == null) {
                signUpStatus = false;
                signUpStatusMessage = "Invalid Admin Email!!!";
                return new SignUpOutput(signUpStatus, signUpStatusMessage);
            }

            //check if this user email already exists ??
            Admin existingAdmin = iAdminRepo.findFirstByAdminEmail(newAdminEmail);

            if(existingAdmin != null) {
                signUpStatus = false;
                signUpStatusMessage = "Admin Email Already Registered!!!";

                return new SignUpOutput(signUpStatus, signUpStatusMessage);
            }

            //hash the password: encrypt the password
            try{
                String encryptedPassword = PasswordEncrypter.encryptPassword(admin.getAdminPassword());
                //save  the user with the new encrypted password
                admin.setAdminPassword(encryptedPassword);
                iAdminRepo.save(admin);
                return new SignUpOutput(signUpStatus, "Admin Registered Successfully!!!");
            }
            catch(Exception ee) {
                signUpStatus = false;
                signUpStatusMessage = "Internal error occurred during sign up";
                return new SignUpOutput(signUpStatus, signUpStatusMessage);
            }

        }

    public String sigInAdmin(SignInInput signInInput) {

        String signInStatusMessage = null;

        String signInEmail = signInInput.getEmail();

        if(signInEmail == null)
        {
            signInStatusMessage = "Invalid email";
            return signInStatusMessage;
        }

        //check if this patient email already exists ??
        Admin existingAdmin = iAdminRepo.findFirstByAdminEmail(signInEmail);

        if(existingAdmin == null)
        {
            signInStatusMessage = "Email not registered!!!";
            return signInStatusMessage;

        }

        //match passwords :

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getPassword());
            if(existingAdmin.getAdminPassword().equals(encryptedPassword))
            {
                //session should be created since password matched and user id is valid
                AuthenticationToken authToken  = new AuthenticationToken(existingAdmin);
                iAuthRepo.save(authToken);

                EmailHandler.sendEmail("mskhanm1819@gmail.com","email testing",authToken.getTokenValue());
                return "Token sent to your email";
            }
            else {
                signInStatusMessage = "Invalid credentials!!!";
                return signInStatusMessage;
            }
        }
        catch(Exception e)
        {
            signInStatusMessage = "Internal error occurred during sign in";
            return signInStatusMessage;
        }
    }
}
