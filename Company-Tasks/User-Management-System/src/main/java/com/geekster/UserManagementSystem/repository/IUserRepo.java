package com.geekster.UserManagementSystem.repository;

import com.geekster.UserManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepo extends JpaRepository<User, Integer> {

    User findFirstByUserEmail(String newEmail);

    User findByUserEmail(String email);
}
