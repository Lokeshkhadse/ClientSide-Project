package com.product.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dao.ProductTabelDao;
import com.product.model.ProductTable;

@Service
public class ProductTableService {
	
	@Autowired
	private ProductTabelDao productDao;

	public List<ProductTable> getAllProduct() {
		return productDao.getAllProduct();
	}

	public void updateProduct(int id, double mrp) {
		productDao.updateProduct(id,mrp);
	}
	
	

}
