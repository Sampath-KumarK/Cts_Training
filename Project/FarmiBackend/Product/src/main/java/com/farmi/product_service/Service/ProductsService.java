package com.farmi.product_service.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmi.product_service.Entity.Products;
import com.farmi.product_service.Repository.ProductsRepository;

@Service
public class ProductsService {
	@Autowired
	private ProductsRepository productsrepo;
	public Products addProducts(Products pro) {
		return productsrepo.save(pro);
	}
	public List<Products> getAllPro(){
		return productsrepo.findAll();
	}
}
