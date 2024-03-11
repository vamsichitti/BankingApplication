package com.bankingapplication.accountmanagement.utils;

import com.bankingapplication.accountmanagement.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.IdGenerator;

import java.util.UUID;
@Component
public class AccountNumberGenerator  {
    @Autowired
    private AccountRepository accountRepository;
    public String generateUniqueAccountNumber() {
        String accountNumber;
        do {
            accountNumber = generateRandomAccountNumber();
        } while (accountRepository.existsByAccountNumber(accountNumber)); // Check for duplicates
        return accountNumber;
    }

    public String generateRandomAccountNumber() {
        // Generate a random 6-digit number as a String
        int randomNumber = (int) (Math.random() * 900000) + 100000;
        return String.valueOf(randomNumber);
    }
}
