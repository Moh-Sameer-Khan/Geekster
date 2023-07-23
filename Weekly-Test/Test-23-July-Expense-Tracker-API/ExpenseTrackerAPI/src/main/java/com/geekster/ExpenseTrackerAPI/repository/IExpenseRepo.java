package com.geekster.ExpenseTrackerAPI.repository;

import com.geekster.ExpenseTrackerAPI.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface IExpenseRepo extends JpaRepository<Expense, Long> {

    List<Expense> findByExpenseCreationDateStamp(LocalDate date);

    List<Expense> findByExpenseCreationDateStampAndExpenseCreationTimeStamp(LocalDate date, LocalTime time);
}
