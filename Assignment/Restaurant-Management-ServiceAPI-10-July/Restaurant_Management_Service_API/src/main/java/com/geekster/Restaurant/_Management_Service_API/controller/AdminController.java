package com.geekster.Restaurant._Management_Service_API.controller;

import com.geekster.Restaurant._Management_Service_API.model.Admin;
import com.geekster.Restaurant._Management_Service_API.model.dto.SignInInput;
import com.geekster.Restaurant._Management_Service_API.model.dto.SignUpOutput;
import com.geekster.Restaurant._Management_Service_API.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;


    @PostMapping("admin/signUp")
    public SignUpOutput signUpAdmin(@RequestBody Admin admin)
    {

        return adminService.signUpAdmin(admin);
    }
    @PostMapping("admin/signIn")
    public String sigInAdmin(@RequestBody @Valid SignInInput signInInput)
    {
        return adminService.sigInAdmin(signInInput);
    }

}
