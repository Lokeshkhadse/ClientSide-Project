package com.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.product.model.ProductTable;

@Repository
public class ProductTabelDao {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<ProductTable> getAllProduct() {
		String sql = "Select * from  producttable";
		
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProductTable.class));
	}

	public void updateProduct(int id, double mrp) {
         String sql = "update producttable set mrp = ? where id = ? ";
         jdbcTemplate.update(sql,mrp,id);
	}

}
