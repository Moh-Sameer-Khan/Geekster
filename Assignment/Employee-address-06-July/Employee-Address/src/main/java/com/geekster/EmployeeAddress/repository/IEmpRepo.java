package com.geekster.EmployeeAddress.repository;

import com.geekster.EmployeeAddress.model.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpRepo extends CrudRepository<Employee, Long> {
    @Modifying
    @Query(value = "update Employee set Emp_First_Name = :empFirstName where emp_Id = :empId", nativeQuery = true)
    Integer updateEmpFirstNameById(Long empId, String empFirstName);
}
