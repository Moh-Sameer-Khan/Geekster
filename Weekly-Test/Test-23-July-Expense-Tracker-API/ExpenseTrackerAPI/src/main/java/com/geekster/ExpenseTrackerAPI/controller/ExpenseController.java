package com.geekster.ExpenseTrackerAPI.controller;

import com.geekster.ExpenseTrackerAPI.entity.Expense;
import com.geekster.ExpenseTrackerAPI.service.AuthenticationService;
import com.geekster.ExpenseTrackerAPI.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@Validated
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @Autowired
    AuthenticationService authenticationService;


    //  creating the expenses // CREATE/POST
    @PostMapping("expense/add")
    public String createExpense(@RequestBody @Valid Expense expense, @RequestParam String email, String tokenValue) {
        boolean authenticateResult = authenticationService.authenticate(email, tokenValue);
        if(authenticateResult) {
            expenseService.createExpense(expense);
            return "Expense Created Successfully!!!";
        }else {
            return "Expense Creating failed because invalid Authentication!!!";
        }
    }

//    Getting --> fetch all the product for a particular date and time // GET/READ
    @GetMapping("expenses/date/time")
    public List<Expense> getAllExpensesByDateAndTime(@RequestParam LocalDate date, @RequestParam LocalTime time) {
        return expenseService.getAllExpensesByDateAndTime(date, time);
    }


}
