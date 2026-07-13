package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    /**
     * REST - Country Web Service returning India details loaded from XML config.
     */
    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public Country getCountryIndia() {
        LOGGER.info("START: getCountryIndia()");
        // Load the XML Application Context to get the India bean explicitly
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country india = context.getBean("in", Country.class);
        LOGGER.info("END: getCountryIndia() returning: {}", india);
        return india;
    }

    /**
     * REST - Get country based on country code (case-insensitive).
     */
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable("code") String code) {
        LOGGER.info("START: getCountry() for code: {}", code);
        Country country = countryService.getCountry(code);
        LOGGER.info("END: getCountry() result: {}", country);
        return country;
    }
}
