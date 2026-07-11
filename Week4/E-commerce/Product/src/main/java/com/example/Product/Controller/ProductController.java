package com.example.Product.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Product.Entity.Product;
import com.example.Product.Repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductRepository productrepo;
	
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product) {
		return productrepo.save(product);
	}
	
	@GetMapping("/allpro")  
	public List<Product> showProducts(){
		return productrepo.findAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Product> GetBYID(@PathVariable("id") Long productID){
		Product product=  productrepo.findById(productID).orElseThrow(() -> new RuntimeException("Product Id Not Found"));
		return ResponseEntity.ok(product);
	}
}
