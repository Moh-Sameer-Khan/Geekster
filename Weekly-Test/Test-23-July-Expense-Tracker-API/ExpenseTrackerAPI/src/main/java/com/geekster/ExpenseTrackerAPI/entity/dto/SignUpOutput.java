package com.geekster.ExpenseTrackerAPI.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignUpOutput {
    private boolean signUpStatus;
    private String signUpStatusMessage;
}
