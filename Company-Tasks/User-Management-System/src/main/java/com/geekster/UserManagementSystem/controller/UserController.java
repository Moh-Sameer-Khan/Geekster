package com.geekster.UserManagementSystem.controller;

import com.geekster.UserManagementSystem.model.User;
import com.geekster.UserManagementSystem.model.dto.SignInInput;
import com.geekster.UserManagementSystem.model.dto.SignUpOutput;
import com.geekster.UserManagementSystem.service.AuthenticationService;
import com.geekster.UserManagementSystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationService authenticationService;

    //sign up particular  user
    @PostMapping("user/signUp")
    public SignUpOutput signUpUser(@RequestBody @Valid User user)
    {

        return userService.signUpUser(user);
    }

    //Sign-In a particular  user
    @PostMapping("user/signIn")
    public String sigInUser(@RequestBody @Valid SignInInput signInInput)
    {
        return userService.sigInUser(signInInput);
    }

    //    Read the data a user who signed user // GET
    @GetMapping("user")
    public User getUser(@RequestParam @Valid String email, @RequestParam String tokenValue) {
//        authentication this user is sign-in, have an account
        boolean authenticateResult = authenticationService.authenticate(email, tokenValue);
        if(authenticateResult) {
//        only authorized user can Get All blogs Post
            return userService.getUser(email);
        }
        else {
            throw  new RuntimeException("Not an Authenticated user activity!!!");
        }
    }
    //    Update the post information
    @PutMapping("user/info/update")
    public String updateUserInfo(@RequestParam @Valid String email, @RequestParam String tokenValue, @RequestBody @Valid User user) {
//        authentication this user is sign-in, have an account
        boolean authenticateResult = authenticationService.authenticate(email, tokenValue);
        if(authenticateResult) {
//        only authorized user can Get All blogs Post
            return userService.updateUserInfo(email, user);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }

}
