package com.geekster.ExpenseTrackerAPI.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
//import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;

    @NotBlank(message = "Expense Title is required")
    private String expenseTitle;

    private String expenseDescription;

//    @NotNull(message = "Expense Price is required")
    @Min(value = 0, message = "Expense Price must be non-negative")
    private Double expensePrice;

//    @NotNull(message = "Expense Date is required")
    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private LocalDate expenseCreationDateStamp;

    private LocalTime expenseCreationTimeStamp;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;
}
