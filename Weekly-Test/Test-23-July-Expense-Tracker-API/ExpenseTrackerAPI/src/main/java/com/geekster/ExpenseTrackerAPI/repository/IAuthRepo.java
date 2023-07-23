package com.geekster.ExpenseTrackerAPI.repository;

import com.geekster.ExpenseTrackerAPI.entity.AuthenticationToken;
import com.geekster.ExpenseTrackerAPI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthRepo extends JpaRepository<AuthenticationToken, Long> {
    AuthenticationToken findFirstByTokenValue(String tokenValue);

    AuthenticationToken findFirstByTokenOwner(User user);
}
