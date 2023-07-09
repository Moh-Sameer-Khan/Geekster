package com.geekster.EcommerceAPI.controller;

import com.geekster.EcommerceAPI.model.Address;
import com.geekster.EcommerceAPI.model.User;
import com.geekster.EcommerceAPI.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    //    Task -- 1 -- Create Address --> Crud Repository (CR) method
    @PostMapping("addresses")
    public String addAddress(@RequestBody Address address) {
        return addressService.addAddress(address);
    }
}
