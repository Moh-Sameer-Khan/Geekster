package com.geekster.EmployeeAddress.service;

import com.geekster.EmployeeAddress.model.Employee;
import com.geekster.EmployeeAddress.repository.IEmpRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    IEmpRepo iEmpRepo;

    public String addEmployees(Employee employees) {
        iEmpRepo.save(employees);
        return "Employees Added Successfully.!!";
    }

    public List<Employee> getAllEmployees() {
        return (List<Employee>) iEmpRepo.findAll(); // we can Type casting or, We can change return type Iterable for findAll()
    }

    public Optional<Employee> getEmpById(Long empId) {
        return iEmpRepo.findById(empId); // or we can return type optional or, we can use .orElse(null) // But both are same work
    }

    @Transactional
    public String updateEmpFirstNameById(Long empId, String empFirstName) {
        Integer updateCount = iEmpRepo.updateEmpFirstNameById(empId, empFirstName);
        if(updateCount > 0) {
            return "Employee, First Name for ID : " + empId + " Successfully Updated!!";
        }else {
            return "Employee, First Name for ID : " + empId + " does not Updated Because it's does not exist!!";
        }
    }

    public String deleteEmpById(Long empId) {
        iEmpRepo.deleteById(empId);
        return "Employee for ID : " + empId + " Successfully Deleted/ Maybe not exist!!";
    }


}
