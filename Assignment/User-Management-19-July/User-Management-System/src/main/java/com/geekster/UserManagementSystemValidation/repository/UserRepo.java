package com.geekster.UserManagementSystemValidation.repository;


import com.geekster.UserManagementSystemValidation.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo {
    @Autowired
    List<User> userList;

    public List<User> getAllUserList() {
        return userList;
    }
}
