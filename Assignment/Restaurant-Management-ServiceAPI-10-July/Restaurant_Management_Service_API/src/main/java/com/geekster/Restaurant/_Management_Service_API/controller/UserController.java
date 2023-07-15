package com.geekster.Restaurant._Management_Service_API.controller;

import com.geekster.Restaurant._Management_Service_API.model.Order;
import com.geekster.Restaurant._Management_Service_API.model.User;
import com.geekster.Restaurant._Management_Service_API.model.dto.SignInInput;
import com.geekster.Restaurant._Management_Service_API.model.dto.SignUpOutput;
import com.geekster.Restaurant._Management_Service_API.service.AuthenticationService;
import com.geekster.Restaurant._Management_Service_API.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;

//  Task -- 1 --> add Users(SIGN-UP) // Post/CREATE // Using Custom Repository Method
    @PostMapping("user/signUp")
    public SignUpOutput signUpUser(@RequestBody @Valid User user) {
        return userService.signUpUser(user);
    }

    //  Task -- 1 --> add Users(SIGN-UP) // Post/CREATE // Using Custom Repository Method
    @PostMapping("user/signIn")
    public String signInUser(@RequestBody @Valid SignInInput signInInput) {
        return userService.signInUser(signInInput);
    }

    @DeleteMapping("user/signOut")
    public String signOutUser(String email, String authToken) {
        boolean validUser = authenticationService.authenticate(email, authToken);
        if(validUser) {
            return userService.signOutUser(email);
        }else {
            return "Sign out not allowed for non authenticated user.";
        }
    }

    @GetMapping("users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("user/order")
    public String addOrder(@RequestBody Order order, String email, String token) {
        boolean validUser = authenticationService.authenticate(email, token);
        if(validUser) {
            boolean status = userService.addOrder(order);
            return status ? " Order Booked!!!" : "Error occurred during booking Order";
        } else {
            return "Order failed because invalid authentication!!!";
        }
    }

}
