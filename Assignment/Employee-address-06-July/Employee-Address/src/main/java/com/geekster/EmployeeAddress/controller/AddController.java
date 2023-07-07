package com.geekster.EmployeeAddress.controller;

import com.geekster.EmployeeAddress.model.Address;
import com.geekster.EmployeeAddress.service.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class AddController {
    @Autowired
    AddService addService;
//  Task -- 1 -- POST /addresses - create a new address
    @PostMapping("addresses")
    public String addAddress(@RequestBody Address addresses) {
        return addService.addAddress(addresses);
    }
//    Task -- 2 --> GET /Addresses - get all addresses
    @GetMapping("addresses")
    public Iterable<Address> getAllAddresses() {
        return addService.getAllAddresses();
    }
//    Task -- 3 --> GET /addresses/{id} - get an address by id
    @GetMapping("addresses/addId/{addressId}")
    public Address getAddressById(@PathVariable Long addressId) {
        return addService.getAddressById(addressId);
    }
//    Task -- 4 --> PUT /addresses/{id} - update an address by id  -- CQ
    @PutMapping("addresses/addId/{addId}/addressCity")
    public String updateAddressCityById(@PathVariable Long addId, @RequestParam String newCity) {
        return addService.updateAddressCityById(addId, newCity);
    }
//    Task -- 5 --> DELETE /addresses/{id} and by State- delete an address by id -- CQ
    @DeleteMapping("addresses/addId/{addId}/state")
    public String deleteAddressByIdAndState(@PathVariable Long addId, @RequestParam String state) {
        return addService.deleteAddressByIdAndState(addId, state);
    }

}
