package com.geekster.UserManagement.controller;

import com.geekster.UserManagement.model.User;
import com.geekster.UserManagement.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;


@RestController
//@Validated
public class UserController {

    @Autowired
    UserService userService;


    //read
    @GetMapping("users")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    //create
    //adding multiple users at a time
    @PostMapping("users/add")
    public String addUsers(@RequestBody @Valid List<User> users)
    {
        return userService.createUsers(users);
    }
//  Adding one user at a time
    @PostMapping("user")
    public String addUser(@Valid @RequestBody User user)
    {
        return userService.createUser(user);
    }

    //delete : delete an user from the list
    @DeleteMapping("user")
    public String removeUser(@RequestParam @Max(10000) Integer id)
    {
        return userService.removeUser(id);
    }

    @RequestMapping(value = "user/{id}/email/{emailId}",method = PUT)
    String updateEmail(@PathVariable Integer id, @PathVariable @Email String emailId)
    {
        return userService.updateEmail(id,emailId);
    }


}
