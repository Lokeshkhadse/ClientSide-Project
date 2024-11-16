package com.product.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.Service.ProductService;
import com.product.model.Product;

@RestController
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @PostMapping("/addproduct")
    public ResponseEntity<String> addProduct(@RequestBody List<Product> product) {
    	 try {
    		  List<Product> addedProducts = productService.addProduct(product);
    	        return new ResponseEntity<>("Product added successfully", HttpStatus.CREATED);  // 201 Created status code
    	    } catch (Exception e) {
    	        return new ResponseEntity<>("Failed to add product: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);  // Handle any error
    	    }
    }
    
    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
    	return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.OK);
    }
}
