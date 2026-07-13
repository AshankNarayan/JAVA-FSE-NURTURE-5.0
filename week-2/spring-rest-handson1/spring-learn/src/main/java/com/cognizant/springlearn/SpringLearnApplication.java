package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Starting SpringLearnApplication main() method...");
        SpringApplication.run(SpringLearnApplication.class, args);
        
        // Execute the XML configuration load and bean retrieval
        displayCountry();
        LOGGER.info("SpringLearnApplication main() execution finished.");
    }

    public static void displayCountry() {
        LOGGER.info("START: displayCountry()");
        // Load context from country.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        
        // Get the country bean from context
        Country country = context.getBean("country", Country.class);
        
        // Log country details
        LOGGER.debug("Country : {}", country.toString());
        LOGGER.info("END: displayCountry()");
    }
}
