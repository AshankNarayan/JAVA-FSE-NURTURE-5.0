package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.entity.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    /**
     * Hands-on 5: Get all countries.
     */
    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    /**
     * Hands-on 6: Find a country based on country code.
     */
    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(countryCode);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country with code '" + countryCode + "' not found!");
        }
        Country country = result.get();
        return country;
    }

    /**
     * Hands-on 7: Add a new country.
     */
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    /**
     * Hands-on 5: Update an existing country.
     */
    @Transactional
    public void updateCountry(String code, String newName) throws CountryNotFoundException {
        Country country = findCountryByCode(code);
        country.setName(newName);
        countryRepository.save(country);
    }

    /**
     * Hands-on 5: Delete a country by code.
     */
    @Transactional
    public void deleteCountry(String code) throws CountryNotFoundException {
        Country country = findCountryByCode(code);
        countryRepository.delete(country);
    }

    /**
     * Hands-on 5: Find countries by partial name match.
     */
    @Transactional
    public List<Country> findCountriesByPartialName(String partialName) {
        return countryRepository.findByNameContainingIgnoreCase(partialName);
    }
}
