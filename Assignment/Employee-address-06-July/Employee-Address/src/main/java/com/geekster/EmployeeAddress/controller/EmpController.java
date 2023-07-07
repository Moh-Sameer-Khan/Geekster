package com.geekster.EmployeeAddress.controller;

import com.geekster.EmployeeAddress.model.Employee;
import com.geekster.EmployeeAddress.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpController {
    @Autowired
    EmpService empService;
//  Task -- 1 --> POST /employees - create a new employee -- CR
    @PostMapping("employees")
    public String addEmployees(@RequestBody Employee employees) {
        return empService.addEmployees(employees);
    }

//    Task -- 2 --> GET /employees - get all employees -- CR
    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        return empService.getAllEmployees();
    }

//    Task -- 3 --> GET /employees/{id} - get an employee by id -- CR
    @GetMapping("employees/empId/{empId}")
    public Optional<Employee> getEmpById(@PathVariable Long empId) {
        return empService.getEmpById(empId);
    }

//    Task -- 4 --> PUT /employees/{id} - update an employee by id  -- CQ
    @PutMapping("employees/empId/{empId}/empFirstName")
    public String updateEmpFirstNameById(@PathVariable Long empId, @RequestParam String empFirstName) {
        return empService.updateEmpFirstNameById(empId, empFirstName);
    }

//    Task -- 5 --> DELETE /employees/{id} - delete an employee by id -- CR
    @DeleteMapping("employees/empId/{empId}")
    public String deleteEmpById(@PathVariable Long empId) {
        return empService.deleteEmpById(empId);
    }


}
