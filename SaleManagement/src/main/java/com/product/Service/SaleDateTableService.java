package com.product.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.Dto.SaleDateTableDto;
import com.product.dao.SaleTableDao;

@Service
public class SaleDateTableService {
	
	@Autowired
	private SaleTableDao saleTableDao;

	public void addDataSaleTable(SaleDateTableDto saleDateTableDto) {
		
		saleTableDao.addDataSaleTable(saleDateTableDto);
	}

}
