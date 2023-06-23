package com.geekster.UserManagementSystem.repository;

import com.geekster.UserManagementSystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Component // or
@Repository
public class UserRepo {
    @Autowired
    List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void addUsers(User user) {
        users.add(user);
    }

    public void removeUsers(Integer userId) {
        users.remove(userId);
    }
}
