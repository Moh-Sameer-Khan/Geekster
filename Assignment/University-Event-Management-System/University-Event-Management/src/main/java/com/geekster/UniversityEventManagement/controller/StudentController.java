package com.geekster.UniversityEventManagement.controller;

import com.geekster.UniversityEventManagement.model.Department;
import com.geekster.UniversityEventManagement.model.Student;
import com.geekster.UniversityEventManagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class StudentController {
    @Autowired
    StudentService studentService;

//    Task -- 1 --> Add Student // Create/Post
    @PostMapping("students")
    public String addStudents(@RequestBody @Valid List<Student> students) {
        return studentService.addStudents(students);
    }
//    Task -- 2 --> Get all students // Get/READ
    @GetMapping("students")
    public Iterable<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

//    Task -- 3 --> Get student by Id // GET/READ
    @GetMapping("students/studentId/{stId}")
    public Student getStudentsById(@PathVariable Long stId) {
        return studentService.getStudentsById(stId);
    }
//    Task -- 4 --> update student department // Update/PUT
    @PutMapping("students/studnetId/{stId}/department/{dept}")
    public String updateStudentInformationById(@PathVariable Long stId, @PathVariable Department dept) {
        return studentService.updateStudentInformationById(stId, dept);
    }

//    Task -- 5 --> delete student // Delete
    @DeleteMapping("students/studentsId/{stId}")
    public String deleteStudentsById(@PathVariable Long stId) {
        return studentService.deleteStudentsById(stId);
    }
}
