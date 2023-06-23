package com.geekster.UserManagementSystem.userController;

import com.geekster.UserManagementSystem.entity.User;
import com.geekster.UserManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // for making api // spring search here if we will hit that api
public class UserController {
//    creating an object of service class // dependency injection by @Autowired
    @Autowired //  now  controller class have access of service class
    UserService userService;

//    Task - 1 --> Get All User  // Read
    @GetMapping("users")  // Type of Api -- Get
    public List<User> getAllUsers() {
//        System.out.println("I'm getting all users Successfully"); // only for test just checking working or not
        return userService.getAllUsers();
    }

//    Task - 2 --> Get User by Id // Read
    @GetMapping("users/{userId}")
    public User getUsersById(@PathVariable Integer userId) {
        return userService.getUsersById(userId);
    }

//    Task - 3 --> Add User  // Create
    @PostMapping("users/add")  // Type of API // Add--> Post/Create
    public String addUsers(@RequestBody User user) { // add a new users in the User a/o class member / json as an object then use @RequestBody
        return userService.addUsers(user);
    }

//    Task - 4 --> update User information // Update

    @PutMapping("users/{userId}/{newPhoneNumber}") // API type Update/Put
    public String updateUserInformation(@PathVariable Integer userId,@PathVariable Integer newPhoneNumber) {
        return userService.updateUsersInformation(userId, newPhoneNumber);
    }

//    Task -- 5 --> delete user // Delete
    @DeleteMapping("users/delete/{userId}") // API type --> Delete
    public String deleteUsers(@PathVariable Integer userId) {
        return userService.removeUsersById(userId);
    }
}
