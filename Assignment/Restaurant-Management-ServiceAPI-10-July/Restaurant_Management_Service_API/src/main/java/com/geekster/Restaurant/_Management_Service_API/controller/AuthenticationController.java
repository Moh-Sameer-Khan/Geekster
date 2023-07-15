package com.geekster.Restaurant._Management_Service_API.controller;

import com.geekster.Restaurant._Management_Service_API.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;
}
