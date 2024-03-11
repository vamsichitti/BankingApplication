package com.bankingapplication.accountmanagement.service;

import com.bankingapplication.accountmanagement.DTO.AccountDto;

import java.util.List;
import java.util.Map;

public interface AccountService {
    public AccountDto createAccount(AccountDto accountDto);
    public List<AccountDto> getAllAccounts();
    public AccountDto depositAmount(Long id, double amount);
    public AccountDto withdrawAmount(Long id, double amount);
}
