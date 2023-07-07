package com.geekster.EmployeeAddress.service;


import com.geekster.EmployeeAddress.model.Address;
import com.geekster.EmployeeAddress.model.Employee;
import com.geekster.EmployeeAddress.repository.IAddRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddService {
    @Autowired
    IAddRepo iAddRepo;

    public String addAddress(Address addresses) {
        iAddRepo.save(addresses);
        return "Address Added Successfully";
    }
    public Iterable<Address> getAllAddresses() {
        return iAddRepo.findAll(); // we can Type casting or, We can change return type Iterable for findAll()
    }

    public Address getAddressById(Long addressId) {
        return iAddRepo.findById(addressId).orElse(null);  // we are using .orElse(null) so we are not doing return type Optional<>
    }
    @Transactional
    public String updateAddressCityById(Long addId, String newCity) {
        Integer updateCount = iAddRepo.updateAddressCityById(addId, newCity);
        if(updateCount > 0) {
            return "Address, City for ID : " + addId + " Successfully Updated!!";
        }else {
            return "Address, City for ID : " + addId + " does not Updated Because it's does not exist!!";
        }
    }

    @Transactional
    public String deleteAddressByIdAndState(Long addId, String state) {
        Integer updateCount = iAddRepo.deleteAddressByIdAndState(addId, state);
        if(updateCount > 0) {
            return "Address for ID : " + addId + " And State : "+ state + " Successfully Deleted!!";
        }else {
            return "Address for ID : " + addId + " And State : "+ state + " Not Deleted!! Because it's not exist";
        }
    }


}
