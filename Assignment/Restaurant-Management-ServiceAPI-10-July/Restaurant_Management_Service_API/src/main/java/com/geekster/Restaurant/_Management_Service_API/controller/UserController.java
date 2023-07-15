package com.geekster.Restaurant._Management_Service_API.controller;

import com.geekster.Restaurant._Management_Service_API.model.User;
import com.geekster.Restaurant._Management_Service_API.model.dto.SignInInput;
import com.geekster.Restaurant._Management_Service_API.model.dto.SignUpOutput;
import com.geekster.Restaurant._Management_Service_API.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
public class UserController {
    @Autowired
    UserService userService;

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

    @GetMapping("users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
