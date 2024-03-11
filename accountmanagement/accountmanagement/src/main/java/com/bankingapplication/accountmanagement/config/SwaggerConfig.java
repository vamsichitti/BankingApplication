package com.bankingapplication.accountmanagement.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {


    public OpenAPI myOpenAPI() {


        Contact contact = new Contact();
        contact.setEmail("accountmanagement@gmail.com");
        contact.setName("Banking");


        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Banking API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints regarding Deposit and withdraw Amount.").termsOfService("https://www.bezkoder.com/terms")
                .license(mitLicense);

        return new OpenAPI().info(info);
    }
}