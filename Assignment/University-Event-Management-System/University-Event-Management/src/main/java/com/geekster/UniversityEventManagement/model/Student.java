package com.geekster.UniversityEventManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    private Long studentId;
    @Column(name = "fname")
    @Pattern(regexp = "[A-Z][a-zA-Z]*", message = "First name should start with a capital letter")
    private String studentFirstName;
    @Column(name = "lname")
    private String studentLastName;
    @Min(value = 18, message = "Minimum age is 18")
    @Max(value = 25, message = "Maximum Age is 25")
    @Column(name = "age")
    private Integer studentAge;
    @Column(name = "department")
    @Enumerated(EnumType.STRING)
    private Department studentDepartment;
}
