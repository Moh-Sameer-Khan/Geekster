package com.geekster.UserManagementSystemValidation.configuration;

import com.geekster.UserManagementSystemValidation.model.Type;
import com.geekster.UserManagementSystemValidation.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanFactory {
    @Bean
    public List<User> getAllUsers() {
//        When I'm Taking LocalDate for DOB
//        User initalizeUser = new User(1, "sameer", LocalDate.of(1999, 10, 01), "mskhanm1819@gmail.com", "918057764459", LocalDate.of(2023, 06, 28), Type.ADMIN, LocalDateTime.now());
//        Date of birth as String type
        User initalizeUser = new User(1, "sameer", "1999-10-01", "mskhanm1819@gmail.com", "918057764459", Type.ADMIN, LocalDate.now(),LocalTime.now());
        List<User> userList = new ArrayList<>();
        userList.add(initalizeUser);
        return userList;
    }
}
