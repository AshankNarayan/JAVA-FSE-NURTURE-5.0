package com.cognizant.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    @GetMapping("/accounts/{number}")
    public Account getAccountDetails(@PathVariable("number") String number) {
        LOGGER.info("START: getAccountDetails for account number: {}", number);
        
        // Dummy mock response as specified in the hands-on description
        Account account = new Account(number, "savings", 234343.0);
        
        LOGGER.info("END: getAccountDetails returning: {}", account);
        return account;
    }
}
