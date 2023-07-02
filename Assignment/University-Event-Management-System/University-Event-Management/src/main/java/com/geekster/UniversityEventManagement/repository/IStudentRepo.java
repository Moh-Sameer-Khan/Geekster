package com.geekster.UniversityEventManagement.repository;

import com.geekster.UniversityEventManagement.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepo extends CrudRepository<Student, Long> {

}
