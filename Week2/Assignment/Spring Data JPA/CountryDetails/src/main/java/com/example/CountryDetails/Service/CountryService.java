package com.example.CountryDetails.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.CountryDetails.Entity.Country;
import com.example.CountryDetails.Repository.CountryRepository;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }


    public Country getCountryById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }


    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountryByName(String name) {
        return countryRepository.findByName(name);
    }
    public Country getCountry(String name) {
        return countryRepository.findByName(name);
    }
}