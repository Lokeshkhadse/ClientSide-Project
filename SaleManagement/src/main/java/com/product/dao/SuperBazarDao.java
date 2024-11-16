package com.product.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.product.Dto.SuperBazarDto;
import com.product.Exception.StoreNotFoundException;
import com.product.model.Sale;
import com.product.model.Store;

@Repository
public class SuperBazarDao {
	
	      @Autowired
	      private JdbcTemplate jdbcTemplate;
	      
	      public List<SuperBazarDto> getSales(int id) {
	    	  
	    	  

	    	    String sql = "SELECT p.productName AS ProductName, "
	    	               + "COALESCE(SUM(s.quantity), 0) AS Quantity, "
	    	               + "p.mrp AS MRP, "
	    	               + "COALESCE(SUM(s.quantity * p.mrp), 0) AS Amount "
	    	               + "FROM Producttable p "
	    	               + "LEFT JOIN Sale s ON p.id = s.p_id AND s.s_id = ? "
	    	               + "GROUP BY p.id, p.productName, p.mrp";
	    	    
	    	    return jdbcTemplate.query(sql, (rs, rowNum) -> {
	    	        SuperBazarDto dto = new SuperBazarDto();

	    	        dto.setProductName(rs.getString("ProductName")); 
	    	        dto.setQuantity(rs.getInt("Quantity"));  
	    	        dto.setMrp(rs.getDouble("MRP")); 
	    	        dto.setAmount(rs.getDouble("Amount"));  
	    	        return dto;
	    	    }, id);
	    	}


	      
	      public Store findbyid(int id) {
	    	    String sql = "SELECT * FROM Store WHERE id = ?";
	    	    try {
	    	        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Store.class), id);
	    	    } catch (Exception e) {
	    	        throw new StoreNotFoundException("Store with ID " + id + " does not exist");

	    	    }
	    	}
      
//	      public Sale findbyDate(Date date) {
//	    	    String sql = "SELECT * FROM Store WHERE id = ?";
//	    	    try {
//	    	        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Sale.class), date);
//	    	    } catch (Exception e) {
//	    	        throw new StoreNotFoundException("date does't exist " + date);
//
//	    	    }
//	    	}


	      public List<SuperBazarDto> getSalesByDateAndS_id(Date date, int id) {
	    	    String sql =  "SELECT p.productName AS ProductName, "
	    	                 + "COALESCE(SUM(s.quantity), 0) AS Quantity, "
	    	                 + "s.mrp AS MRP, "
	    	                 + "COALESCE(SUM(s.quantity * s.mrp), 0) AS Amount "
	    	                 + "FROM Producttable p "
	    	                 + "JOIN Sale s ON p.id = s.p_id AND s.s_id = ? AND s.s_date = ? "
	    	                 + "GROUP BY p.id, p.productName, s.mrp";
	    	    
	    	    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SuperBazarDto.class), id, date);
	    	}





}
