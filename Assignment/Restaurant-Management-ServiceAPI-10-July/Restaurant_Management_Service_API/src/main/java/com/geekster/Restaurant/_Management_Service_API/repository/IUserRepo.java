package com.geekster.Restaurant._Management_Service_API.repository;

import com.geekster.Restaurant._Management_Service_API.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User, Long> {

    User findFirstByUserEmail(String newUserEmail);
}
