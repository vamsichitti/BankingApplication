package com.bankingapplication.accountmanagement.service;

import com.bankingapplication.accountmanagement.DTO.AccountDto;
import com.bankingapplication.accountmanagement.DTO.AccountMapper;
import com.bankingapplication.accountmanagement.entity.Account;
import com.bankingapplication.accountmanagement.repository.AccountRepository;
import com.bankingapplication.accountmanagement.utils.AccountNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountNumberGenerator accountNumberGenerator;
    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = accountMapper.mapToAccount(accountDto);
        account.setAccountNumber(accountNumberGenerator.generateUniqueAccountNumber());
        accountRepository.save(account);
        return accountMapper.mapToAccountDto(account);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<AccountDto> listOfAccounts = new ArrayList<>();
        listOfAccounts = accountRepository.findAll().stream().map(account -> accountMapper.mapToAccountDto(account)).collect(Collectors.toList());
        return listOfAccounts;
    }

    @Override
    public AccountDto depositAmount(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("No account exists with ID "+id));
        account.setBalance(account.getBalance()+amount);
        accountRepository.save(account);
        return accountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto withdrawAmount(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("No account exists with ID "+id));
           if(amount > account.getBalance()){
               throw new RuntimeException("insufficient funds");
           }
           account.setBalance(account.getBalance()-amount);
           accountRepository.save(account);
        return accountMapper.mapToAccountDto(account);
    }
}
