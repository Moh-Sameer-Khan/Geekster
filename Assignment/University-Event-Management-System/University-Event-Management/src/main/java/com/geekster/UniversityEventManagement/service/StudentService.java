package com.geekster.UniversityEventManagement.service;

import com.geekster.UniversityEventManagement.model.Department;
import com.geekster.UniversityEventManagement.model.Student;
import com.geekster.UniversityEventManagement.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    IStudentRepo iStudentRepo;

    public String addStudents(List<Student> students) {
        iStudentRepo.saveAll(students);
        return "Students Added Successfully";
    }

    public Iterable<Student> getAllStudents() {
        return iStudentRepo.findAll();
    }

    public Student getStudentsById(Long stId) {
        Optional<Student> studentOptional = iStudentRepo.findById(stId);
        if(studentOptional.isEmpty()) { // without this exception throw so we must use this
            return null;
        }
        return studentOptional.get();
    }

    public String updateStudentInformationById(Long stId, Department dept) {
        Optional<Student> studentOptional = iStudentRepo.findById(stId);
//        we want actual object so we use
        Student student = null;
        if(studentOptional.isPresent()) {
            student = studentOptional.get();
        }else {
            return "For Student ID : " + stId + " Not Updated bcz not exist";
        }
        student.setStudentDepartment(dept);
        iStudentRepo.save(student);
        return "For Studnet ID : " + stId + " Updated Successfully";
    }

    public String deleteStudentsById(Long stId) {
        iStudentRepo.deleteById(stId);
        return "Student For Id : " + stId + " Successfully Deleted";
    }
}
