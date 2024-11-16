package com.product.Controller;

import com.product.Dto.SaleDateTableDto;
import com.product.Dto.SuperBazarDto;
import com.product.Service.ProductTableService;
import com.product.Service.SaleDateTableService;
import com.product.Service.SuperBazarService;
import com.product.model.ProductTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class SuperBazarController {

    @Autowired
    private SuperBazarService superBazarService;
    
    @Autowired
    private SaleDateTableService saleDateTableService;
    
    @Autowired
    private ProductTableService productService;

    @GetMapping("/sales/{id}")
    public ResponseEntity<List<SuperBazarDto>> getAllSales(@PathVariable int id) {
        List<SuperBazarDto> salesData = superBazarService.getAllSales(id);
        return new ResponseEntity<>(salesData, HttpStatus.OK);
    }
    
    @PostMapping("/addsaleTable")
    private ResponseEntity<String> addDataSaleTable(@RequestBody SaleDateTableDto saleDateTableDto){
    	
    	
    	try {
    		saleDateTableService.addDataSaleTable(saleDateTableDto);  
    		return new ResponseEntity<>("Product added successfully", HttpStatus.CREATED);  
  	    } catch (Exception e) {
  	        return new ResponseEntity<>("Failed to add product: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);  
  	    }
    	
    }
    
    @GetMapping("/dateId")
    public ResponseEntity<List<SuperBazarDto>>getSalesByDateAndS_id(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date , @RequestParam("id") int id){
    	List<SuperBazarDto>salesDataByDateAndId = superBazarService.getSalesByDateAndS_id(date , id);
    	return new ResponseEntity<>(salesDataByDateAndId,HttpStatus.OK);
    }
    
    @GetMapping("/producttable")
    public ResponseEntity<List<ProductTable>>getAllProduct(){
    	return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.OK);
    }
    
    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable("id")int id , @RequestParam("mrp") double mrp){
    	productService.updateProduct(id, mrp);
    	return new ResponseEntity<>("succesfully updated",HttpStatus.OK);
    }
}
