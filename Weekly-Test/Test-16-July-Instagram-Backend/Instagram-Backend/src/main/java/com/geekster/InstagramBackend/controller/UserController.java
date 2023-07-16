package com.geekster.InstagramBackend.controller;

import com.geekster.InstagramBackend.model.User;
import com.geekster.InstagramBackend.model.dto.SignInInput;
import com.geekster.InstagramBackend.model.dto.SignInInputSession;
import com.geekster.InstagramBackend.model.dto.SignUpOutput;
import com.geekster.InstagramBackend.service.AuthenticationService;
import com.geekster.InstagramBackend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;

//    User SIGN-UP, Instagram Account -- Post/Create
    @PostMapping("user/signUp")
    public SignUpOutput userSignUp(@RequestBody @Valid User user) {
        return userService.userSignUp(user);
    }

//    User SIGN-IN, Instagram Account -- Post/Create
    @PostMapping("user/signIn")
    public String signInInstaUser(@RequestBody @Valid SignInInput signInInput) {
        return userService.signInInstaUser(signInInput);
    }

//    Update User details --UPDATE
    @PutMapping("user/update/details")
    public String updateInstaInformation(@RequestBody User user, SignInInputSession signInInputSession) {

        boolean validAuthentication = authenticationService.authenticate(signInInputSession);
        if(validAuthentication) {
            userService.updateInstaInformation(user, signInInputSession);
            return "User Information Updated Successfully!!!";
        }else {
            return "Sorry You can not update information because invalid Authentication!!";
        }
    }
}
