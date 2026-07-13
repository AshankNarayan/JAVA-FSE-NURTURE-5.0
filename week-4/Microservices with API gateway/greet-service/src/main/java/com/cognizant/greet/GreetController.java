package com.cognizant.greet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetController.class);

    @GetMapping("/greet")
    public String greet() {
        LOGGER.info("START: greet() endpoint hit");
        String message = "Hello World";
        LOGGER.info("END: greet() returning: {}", message);
        return message;
    }
}
