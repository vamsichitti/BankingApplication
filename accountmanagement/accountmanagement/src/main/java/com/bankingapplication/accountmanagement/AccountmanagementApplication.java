package com.bankingapplication.accountmanagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Banking API",description = "To Deposit and withdraw Amount"))
public class AccountmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountmanagementApplication.class, args);
	}

}
