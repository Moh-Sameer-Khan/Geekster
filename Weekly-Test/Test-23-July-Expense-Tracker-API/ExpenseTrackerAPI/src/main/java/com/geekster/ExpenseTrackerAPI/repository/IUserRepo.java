package com.geekster.ExpenseTrackerAPI.repository;

import com.geekster.ExpenseTrackerAPI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User, Long> {

    User findFirstByUserEmail(String newUserEmail);

    User findFirstByUsername(String signInUsername);
}
