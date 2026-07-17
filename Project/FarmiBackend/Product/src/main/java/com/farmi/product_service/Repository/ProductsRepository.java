package com.farmi.product_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmi.product_service.Entity.Products;
@Repository
public interface ProductsRepository extends JpaRepository<Products,Long>{
	
}
