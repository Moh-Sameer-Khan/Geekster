package com.geekster.UserManagementSystemValidation.service;

import com.geekster.UserManagementSystemValidation.model.User;
import com.geekster.UserManagementSystemValidation.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public String addUsers(List<User> user) {
        List<User> userList = userRepo.getAllUserList();
        userList.addAll(user);
        return "Added Successfully";
    }

    public List<User> getAllUsers() {
        return userRepo.getAllUserList();
    }

    public String addUser(User user) {
        List<User> userList = getAllUsers();
        userList.add(user);
        return "User Added Successfully!!!!";
    }

    public User getUserById(Integer userId) {
        List<User> userList = getAllUsers();
        for(User user : userList) {
            if(user.getUserId().equals(userId)) {
                return  user;
            }
        }
        return null;
    }

    public String updateUserInformation(Integer userId, String emailId) {
        List<User> userList = getAllUsers();
        for(User user : userList) {
            if(userId.equals(user.getUserId())) {
//                userList.remove(emailId);
//                user.setUserEmail(emailId);
//                userList.add(user);

//                or we can use this
                user.setUserEmail(emailId);
                return "User Information for ID : " + userId + " Successfully Updated!!";
            }
        }
        return "User ID " + userId + " not found so user information not updated";
    }

    public String removeUserById(Integer userId) {
        List<User> userList = getAllUsers();
        for(User user : userList) {
            if(userId.equals(user.getUserId())) {
                userList.remove(user);
                return "User ID : " + userId + " Successfully Deleted!!";
            }
        }
        return "User ID " + userId + " not found so user not Deleted";
    }
}
