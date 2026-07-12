package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    /**
     * Find countries whose name contains the given partial name (case-insensitive).
     */
    List<Country> findByNameContainingIgnoreCase(String partialName);
}
