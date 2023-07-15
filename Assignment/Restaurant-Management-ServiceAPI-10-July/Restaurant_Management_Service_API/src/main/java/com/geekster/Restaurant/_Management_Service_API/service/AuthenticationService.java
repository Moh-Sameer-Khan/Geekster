package com.geekster.Restaurant._Management_Service_API.service;

import com.geekster.Restaurant._Management_Service_API.repository.IAuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    IAuthRepo iAuthRepo;
}
