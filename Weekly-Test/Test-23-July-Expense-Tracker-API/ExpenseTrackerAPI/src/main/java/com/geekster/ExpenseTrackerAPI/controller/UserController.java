package com.geekster.ExpenseTrackerAPI.controller;

import com.geekster.ExpenseTrackerAPI.entity.Expense;
import com.geekster.ExpenseTrackerAPI.entity.User;
import com.geekster.ExpenseTrackerAPI.entity.dto.AuthInput;
import com.geekster.ExpenseTrackerAPI.entity.dto.SignInInput;
import com.geekster.ExpenseTrackerAPI.entity.dto.SignUpOutput;
import com.geekster.ExpenseTrackerAPI.service.AuthenticationService;
import com.geekster.ExpenseTrackerAPI.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;


//    User SIGN-UP, --> create/POST
    @PostMapping("user/signUp")
    public SignUpOutput userSignUp(@RequestBody @Valid User user) {
        return userService.userSignUp(user);
    }

//    User SIGN-IN, POST/CREATE
    @PostMapping("user/signIn")
    public String userSignIn(@RequestBody @Valid SignInInput signInInput) {
        return userService.userSignIn(signInInput);
    }

//    User creating the expenses // CREATE/POST
    @PostMapping("user/expenses/add")
    public String createExpense(@RequestBody @Valid Expense expense, @RequestParam @Valid String email, String tokenValue) {
        boolean authenticateResult = authenticationService.authenticate(email, tokenValue);
        if(authenticateResult) {
            userService.createExpense(expense);
            return "Expense Created Successfully!!!";
        }else {
            return "Expense Creating failed because invalid Authentication";
        }
    }

//    User -- SIGN-OUT // DELETE
    @DeleteMapping("user/signOut")
    public String userSignOut(@RequestBody @Valid AuthInput authInput) {
        boolean authenticateValid = authenticationService.authenticateUser(authInput);
        if(authenticateValid) {
            userService.userSignOut(authInput);
            return "User Signed Out Successfully!!!";
        }else {
            return "Sign out not allowed for non authenticated user.";
        }
    }
}
