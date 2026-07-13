package com.cognizant.springlearn.service;

import com.cognizant.springlearn.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
    
    private final List<Country> countries;

    @SuppressWarnings("unchecked")
    public CountryService() {
        LOGGER.info("Initializing CountryService and loading country list from country.xml...");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        this.countries = context.getBean("countries", List.class);
        LOGGER.info("Country list loaded successfully. Total countries: {}", countries.size());
    }

    /**
     * Search country by code case-insensitively using Java Streams.
     */
    public Country getCountry(String code) {
        LOGGER.info("START getCountry for code: {}", code);
        Country result = countries.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
        LOGGER.info("END getCountry. Result found: {}", (result != null));
        return result;
    }
}
