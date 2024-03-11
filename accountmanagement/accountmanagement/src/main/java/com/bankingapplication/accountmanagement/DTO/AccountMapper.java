package com.bankingapplication.accountmanagement.DTO;

import com.bankingapplication.accountmanagement.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public AccountDto mapToAccountDto(Account account){
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setAccountHolderName(account.getAccountHolderName());
        accountDto.setBalance(account.getBalance());
        return accountDto;
    };

    public Account mapToAccount(AccountDto accountDto){
        Account account = new Account();
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setAccountHolderName(accountDto.getAccountHolderName());
        account.setBalance(accountDto.getBalance());
        return account;

    }
}
