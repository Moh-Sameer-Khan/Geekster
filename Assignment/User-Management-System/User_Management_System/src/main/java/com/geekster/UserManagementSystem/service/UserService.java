package com.geekster.UserManagementSystem.service;

import com.geekster.UserManagementSystem.entity.User;
import com.geekster.UserManagementSystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

//    Get all users
    public List<User> getAllUsers() {
        return userRepo.getUsers();
    }

//    Add one by one , users in the User
    public String addUsers(User user) {
        userRepo.addUsers(user);
        return "⚠ new user added Successfully, Thanks!! 👍";
    }

//   Get a particular users form User
    public User getUsersById(Integer userId) {
//        we need Iterator to find which id of user we want
        for(User user : userRepo.getUsers()) {
            if(user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

//    Update the user Information
    public String updateUsersInformation(Integer userId, Integer newPhoneNumber) {
//        we need Iterator to find which id of user we want update information
        for(User user : userRepo.getUsers()) {
            //                if match user id then update user information
            if(user.getUserId().equals(userId)) {
                 user.setPhoneNumber(newPhoneNumber);
                 return "User information Updated for user ID : " + userId;
            }
        }
        return "🔺 User Not Found for user ID : " + userId;
    }

//    Delete any particular users by id
    public String removeUsersById(Integer userId) {
//        we need Iterator to find which id of user we want update information
        for(User user : userRepo.getUsers()) {
//            if match any user id then delete that user id
            if(user.getUserId().equals(userId)) {
                userRepo.removeUsers(userId);
                return "❌ Users removed from User for user ID : " + userId;
            }
        }
        return "User ID - " + userId + " was not deleted because this user id does not exist ..!";
    }
}
