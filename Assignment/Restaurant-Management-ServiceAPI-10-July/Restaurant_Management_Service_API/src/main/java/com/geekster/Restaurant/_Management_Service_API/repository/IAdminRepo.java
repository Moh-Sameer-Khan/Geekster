package com.geekster.Restaurant._Management_Service_API.repository;

import com.geekster.Restaurant._Management_Service_API.model.Admin;
import com.geekster.Restaurant._Management_Service_API.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepo extends JpaRepository<Admin, Long> {
    Admin findFirstByAdminEmail(String newAdminEmail);
}
