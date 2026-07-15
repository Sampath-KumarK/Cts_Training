package com.farmi.Farmer_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmi.Farmer_service.Entity.Farmers;
@Repository
public interface FarmerRepository extends JpaRepository<Farmers,Long> {
	
}
