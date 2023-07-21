package com.geekster.UserManagementSystemValidation.controller;

import com.geekster.UserManagementSystemValidation.model.User;
import com.geekster.UserManagementSystemValidation.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class UserController {
    @Autowired
    UserService userService;

    //    Step -- 1 --> Add user // adding Multiple user// CREATE
    @PostMapping("users/add")
    public String addUsers(@RequestBody @Valid List<User> user) {
        return userService.addUsers(user);
    }

    //    Step -- 2 --> Add user // adding single user at a time // CREATE
//  Here not need Validated
    @PostMapping("user/add")
    public String addUser(@Valid @RequestBody User user) {
        return userService.addUser(user);
    }

    //    Step -- 2 --> Get All User // READ
    @GetMapping("users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
//    Step -- 3 --> Get User by ID // READ
//    we can use validation in this class also but, we need @Validated in the class
    @GetMapping("users/userId")
    public User getUserById(@RequestParam @Max(value = 20, message = "Maximum User Id can be 20") @Min(value = 0, message = "Minimum User Id can be 0") Integer userId) {
        return userService.getUserById(userId);
    }

//    Step -- 4 --> Update user Information // UPDATE
//    here also I'm using @Email annotation so, we will update by the valid email so, it's need @Validated in the class
    @PutMapping("users/{userId}/{emailId}")
    public String updateUserInformation(@PathVariable Integer userId, @PathVariable @Email String emailId) {
        return userService.updateUserInformation(userId, emailId);
    }

//    Step -- 5 --> Delete User by id // DELETE
    @DeleteMapping("users/{userId}")
    public String deleteUserById(@PathVariable @Min(value = 0, message = "Minimum User id is 0") @Max(value = 10, message = "Maximum user Id 10") Integer userId) {
        return userService.removeUserById(userId);
    }

}