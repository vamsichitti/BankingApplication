package com.bankingapplication.accountmanagement.controller;

import com.bankingapplication.accountmanagement.DTO.AccountDto;
import com.bankingapplication.accountmanagement.entity.Account;
import com.bankingapplication.accountmanagement.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountServiceImpl accountService;

    @PostMapping("/create")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto){
        AccountDto accountDto1 = accountService.createAccount(accountDto);

        return new ResponseEntity<>(accountDto1, HttpStatus.CREATED);
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accountDtoList = accountService.getAllAccounts();
        return new ResponseEntity<>(accountDtoList,HttpStatus.OK);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,@RequestBody Map<String,Double> request){
        AccountDto accountDto = accountService.depositAmount(id,request.get("amount"));
        return new ResponseEntity<>(accountDto,HttpStatus.OK);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,@RequestBody Map<String,Double> request){
        AccountDto accountDto = accountService.withdrawAmount(id,request.get("amount"));
        return new ResponseEntity<>(accountDto,HttpStatus.OK);
    }
}
