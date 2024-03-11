package com.bankingapplication.accountmanagement.repository;

import com.bankingapplication.accountmanagement.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{
    boolean existsByAccountNumber(String accountNumber);
};
