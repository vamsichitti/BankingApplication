package com.bankingapplication.accountmanagement.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
}
