package com.geekster.JobSearchPortal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // It's used for persist the entity in the database
//@Table(name = "jobs") // change the table name as we want
public class Job {
    @Id // making for primary key
    private Long jobId;

    @NotBlank  // Now jobTitle can not be null
    private String jobTitle;

    @Column(name = "description")  // for changing the name of the column as we want
    private String jobDescription;

    @NotBlank
    @Column(name = "location")
    private String jobLocation;

    @Column(name = "salary")
    @Min(value = 20000, message = "Salary should be above 20,000")
    @Max(value = 200000, message = "Salary should be below 2,00,000")
    private Double jobSalary;

    @NotBlank
    @Email(message = "Email is Invalid!!")
    private String companyEmail;

    @NotBlank
    private String  companyName;

    @NotBlank
    private String employerName;

//    @NotNull(message = "Type(ENUM) can not blank so please MANAGER, HR, SALES, IT, MARKETING , provide anyone in these..") // It does not work in ENUM // By the way enum also have validation itself
    @Column(name = "type")
    @Enumerated(EnumType.STRING)  // For showing the Enum Values otherwise Index shows in the h2 Database
    private Type jobType;

//    @NotBlank(message = "Date Can not be Blank please provide yyyy-mm-dd in this format")
    @Column(name = "applyDate")
    private LocalDate jobAppliedDate;

}
