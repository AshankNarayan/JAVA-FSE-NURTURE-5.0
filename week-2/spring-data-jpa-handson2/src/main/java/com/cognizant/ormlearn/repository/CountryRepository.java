package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Find countries containing partial name
    List<Country> findByNameContaining(String name);

    // Find countries containing partial name ordered by name ascending
    List<Country> findByNameContainingOrderByNameAsc(String name);

    // Find countries starting with prefix (e.g., 'Z')
    List<Country> findByNameStartingWith(String prefix);
}
