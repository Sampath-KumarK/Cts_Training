package com.example.CountryDetails.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CountryDetails.Entity.Country;
public interface CountryRepository extends JpaRepository<Country,Long>{
    
}

