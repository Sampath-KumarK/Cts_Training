package com.farmi.Farmer_service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmi.Farmer_service.Entity.Farmers;
import com.farmi.Farmer_service.Service.FarmersService;

@RestController
@RequestMapping("/api")
public class Farmer_Controller {

    @Autowired
    private FarmersService farmersService;

    @PostMapping("/add")
    public Farmers addFarmers(@RequestBody Farmers farmer) {
        return farmersService.addFarmer(farmer);
    }
    @PostMapping("/addAll")
    public List<Farmers> addAllFarmers(@RequestBody List<Farmers> farmers) {
        return farmersService.addAllFarmers(farmers);
    }

    @GetMapping("/getall")
    public List<Farmers> getAll() {
        return farmersService.getAllFarmers();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Farmers> getById(@PathVariable Long id) {
        return farmersService.getFarmerById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Farmers> updateFarmer(@PathVariable Long id,
                                                @RequestBody Farmers farmerDetails) {
        return farmersService.updateFarmer(id, farmerDetails);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFarmer(@PathVariable Long id){
    	return farmersService.deleteFarmer(id);
    }
}