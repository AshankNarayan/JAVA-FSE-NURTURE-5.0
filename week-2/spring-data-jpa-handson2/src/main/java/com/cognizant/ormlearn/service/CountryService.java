package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.entity.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> findCountriesContaining(String name) {
        return countryRepository.findByNameContaining(name);
    }

    @Transactional
    public List<Country> findCountriesContainingSorted(String name) {
        return countryRepository.findByNameContainingOrderByNameAsc(name);
    }

    @Transactional
    public List<Country> findCountriesStartingWith(String prefix) {
        return countryRepository.findByNameStartingWith(prefix);
    }
}
