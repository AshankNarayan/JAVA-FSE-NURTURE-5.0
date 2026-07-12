package com.cognizant.ormlearn;

import com.cognizant.ormlearn.entity.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        // Hands-on 5: Get all countries
        getAllCountriesTest();

        // Hands-on 6: Find country by code
        findCountryByCodeTest();

        // Hands-on 7: Add a new country
        testAddCountry();

        // Hands-on 5: Update a country
        testUpdateCountry();

        // Hands-on 5: Delete a country
        testDeleteCountry();

        // Hands-on 5: Find countries by partial name
        testFindByPartialName();
    }

    /**
     * Hands-on 5: Test retrieving all countries.
     */
    private static void getAllCountriesTest() {
        LOGGER.info("=== getAllCountriesTest: Start ===");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("Total countries loaded: {}", countries.size());
        // Print first 5 for brevity
        countries.stream().limit(5).forEach(c -> LOGGER.debug("Country: {}", c));
        LOGGER.info("=== getAllCountriesTest: End ===");
    }

    /**
     * Hands-on 6: Test finding a country by code.
     */
    private static void findCountryByCodeTest() {
        LOGGER.info("=== findCountryByCodeTest: Start ===");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
        LOGGER.info("=== findCountryByCodeTest: End ===");
    }

    /**
     * Hands-on 7: Test adding a new country.
     */
    private static void testAddCountry() {
        LOGGER.info("=== testAddCountry: Start ===");
        Country newCountry = new Country("ZZ", "Testland");
        countryService.addCountry(newCountry);
        LOGGER.debug("Added country: {}", newCountry);

        // Verify the country was added
        try {
            Country fetched = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Verified added country: {}", fetched);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Failed to verify added country: {}", e.getMessage());
        }
        LOGGER.info("=== testAddCountry: End ===");
    }

    /**
     * Hands-on 5: Test updating a country.
     */
    private static void testUpdateCountry() {
        LOGGER.info("=== testUpdateCountry: Start ===");
        try {
            countryService.updateCountry("ZZ", "Updated Testland");
            Country updated = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Updated country: {}", updated);
        } catch (CountryNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
        LOGGER.info("=== testUpdateCountry: End ===");
    }

    /**
     * Hands-on 5: Test deleting a country.
     */
    private static void testDeleteCountry() {
        LOGGER.info("=== testDeleteCountry: Start ===");
        try {
            countryService.deleteCountry("ZZ");
            LOGGER.debug("Deleted country with code: ZZ");
        } catch (CountryNotFoundException e) {
            LOGGER.error(e.getMessage());
        }

        // Verify deletion
        try {
            countryService.findCountryByCode("ZZ");
            LOGGER.error("Country ZZ still exists after deletion!");
        } catch (CountryNotFoundException e) {
            LOGGER.debug("Verified: Country ZZ successfully deleted.");
        }
        LOGGER.info("=== testDeleteCountry: End ===");
    }

    /**
     * Hands-on 5: Test finding countries by partial name.
     */
    private static void testFindByPartialName() {
        LOGGER.info("=== testFindByPartialName: Start ===");
        List<Country> countries = countryService.findCountriesByPartialName("land");
        LOGGER.debug("Countries matching 'land':");
        countries.forEach(c -> LOGGER.debug("  {}", c));
        LOGGER.info("=== testFindByPartialName: End ===");
    }
}
