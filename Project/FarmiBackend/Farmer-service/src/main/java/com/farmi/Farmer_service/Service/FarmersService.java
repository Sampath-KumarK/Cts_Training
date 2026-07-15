package com.farmi.Farmer_service.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.farmi.Farmer_service.Entity.Farmers;
import com.farmi.Farmer_service.Repository.FarmerRepository;

@Service
public class FarmersService {

    @Autowired
    private FarmerRepository farmerRepo;

    public Farmers addFarmer(Farmers farmer) {
        return farmerRepo.save(farmer);
    }
    public List<Farmers> addAllFarmers(List<Farmers> farmers) {
        return farmerRepo.saveAll(farmers);
    }

    public List<Farmers> getAllFarmers() {
        return farmerRepo.findAll();
    }

    public ResponseEntity<Farmers> getFarmerById(Long id) {
        Farmers farmer = farmerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Farmer ID not found"));

        return ResponseEntity.ok(farmer);
    }

    public ResponseEntity<Farmers> updateFarmer(Long id, Farmers farmerDetails) {

        Farmers farmer = farmerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Farmer ID not found"));

        farmer.setName(farmerDetails.getName());
        farmer.setEmail(farmerDetails.getEmail());
        farmer.setPhoneNumber(farmerDetails.getPhoneNumber());
        farmer.setPlace(farmerDetails.getPlace());

        Farmers updatedFarmer = farmerRepo.save(farmer);

        return ResponseEntity.ok(updatedFarmer);
    }
    
    public ResponseEntity<String> deleteFarmer(Long id){
        if (!farmerRepo.existsById(id)) {
            throw new RuntimeException("Farmer ID not found");
        }
        farmerRepo.deleteById(id);
        return ResponseEntity.ok("Farmer deleted successfully");
    }
}