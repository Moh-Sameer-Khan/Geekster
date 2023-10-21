package com.geekster.UserManagementSystem.repository;

import com.geekster.UserManagementSystem.model.AuthenticationToken;
import com.geekster.UserManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthRepo extends JpaRepository<AuthenticationToken, Integer> {

    AuthenticationToken findFirstByTokenValue(String tokenValue);
}
