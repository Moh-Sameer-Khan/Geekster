package com.geekster.ExpenseTrackerAPI.service;

import com.geekster.ExpenseTrackerAPI.entity.Expense;
import com.geekster.ExpenseTrackerAPI.repository.IExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    IExpenseRepo iExpenseRepo;


    public void saveExpense(Expense expense) {
        iExpenseRepo.save(expense);
    }

    public void createExpense(Expense expense) {
        iExpenseRepo.save(expense);
    }

    public List<Expense> getAllExpensesByDateAndTime(LocalDate date, LocalTime time) {
        if(time != null) {
            return iExpenseRepo.findByExpenseCreationDateStampAndExpenseCreationTimeStamp(date, time);
        }else {
            return iExpenseRepo.findByExpenseCreationDateStamp(date);
        }
    }
}
