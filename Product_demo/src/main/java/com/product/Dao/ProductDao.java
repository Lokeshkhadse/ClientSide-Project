package com.product.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.product.model.Product;
@Repository
public class ProductDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;


	   
	   public void insertProduct(Product product) {
	        String sql = "INSERT INTO product (name, size, unit, price) VALUES (?, ?, ?, ?)";
	        jdbcTemplate.update(sql, product.getName(), product.getSize(), product.getUnit(), product.getPrice());
	    }

	    public List<Product> getAllProduct() {
	        String sql = "SELECT * FROM product";
	        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
	    }


}
