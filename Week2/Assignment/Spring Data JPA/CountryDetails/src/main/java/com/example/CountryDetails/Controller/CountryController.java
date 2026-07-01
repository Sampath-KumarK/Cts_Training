package com.example.CountryDetails.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CountryDetails.Entity.Country;
import com.example.CountryDetails.Repository.CountryRepository;

@RestController
@RequestMapping("/api")
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;
    @GetMapping("/hai")
    public String getCountryDetails() {
        return "Country details endpoint";
    }
    @PostMapping("/addcountry")
    public String addCountry(@RequestBody Country country) {
        countryRepository.save(country);
        return "Country added successfully";
    }
}