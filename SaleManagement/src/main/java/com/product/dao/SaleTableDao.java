package com.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.product.Dto.SaleDateTableDto;
import com.product.Dto.SaleTableDto;

@Repository
public class SaleTableDao {
     
           @Autowired
           private JdbcTemplate jdbcTemplate;
           


           public void addDataSaleTable(SaleDateTableDto saleDateTableDto) {
               
               String sql = "INSERT INTO sale (p_id, quantity, s_id, mrp, s_date) VALUES (?, ?, ?, ?, ?)";
               
               // Get the list of SaleTableDto from SaleDateTableDto
               List<SaleTableDto> salesList = saleDateTableDto.getSalesTableDto();
               
               for (SaleTableDto sale : salesList) {
                   jdbcTemplate.update(sql, 
                       sale.getP_id(),        
                       sale.getQuantity(),    
                       sale.getS_id(),        
                       sale.getMrp(),         
                       saleDateTableDto.getS_date()  
                   );
               }
           }

}
