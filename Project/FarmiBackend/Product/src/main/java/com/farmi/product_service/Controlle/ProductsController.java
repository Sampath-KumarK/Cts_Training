package com.farmi.product_service.Controlle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmi.product_service.Entity.Products;
import com.farmi.product_service.Service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {
	@Autowired 
	private ProductsService productsservice;
	@PostMapping("/add")
	public Products addProducts(@RequestBody Products pro) {
		return productsservice.addProducts(pro);
	}
	@GetMapping("/getall")
	public List<Products> getAll(){
		return productsservice.getAllPro();
	}

}
