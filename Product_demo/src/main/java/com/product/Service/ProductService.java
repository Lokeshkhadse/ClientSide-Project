package com.product.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.product.Dao.ProductDao;
import com.product.model.Product;

@Service
public class ProductService {
    
    @Autowired
    private ProductDao productDao;

 
    public List<Product> addProduct(List<Product> product) {
        List<Product> duplicate = new ArrayList<>();
        List<Product> unique = new ArrayList<>();
        List<Product> allProducts = productDao.getAllProduct();

        for (Product newProduct : product) {
            boolean isDuplicate = false;
            for (Product existingProduct : allProducts) {
                if (existingProduct.getName().equals(newProduct.getName()) && existingProduct.getSize() == newProduct.getSize()) {
                    isDuplicate = true;
                    break;
                }
            }

            if (isDuplicate) {
                duplicate.add(newProduct);
            } else {
            	for(Product uniquecheck:unique) {
            		if(uniquecheck.getName().equals(newProduct.getName()) && uniquecheck.getSize() == newProduct.getSize()) {
            			isDuplicate = true;
            			
            		}
            		
            	}
            	if(isDuplicate) {
                duplicate.add(newProduct);
                 }else {
                	 unique.add(newProduct);
                 }
            }
        }

        for (Product uniqueProduct : unique) {
            productDao.insertProduct(uniqueProduct);
        }
        
        
        String duplidetails = "";
        String unidetails = "";
        
        if (duplicate.size() > 0) {
            for (Product dp : duplicate) {
                duplidetails = duplidetails + "[NAME: " + dp.getName() + " SIZE " + dp.getSize() + " ]";

            }
        }

        if (unique.size() > 0) {
            for (Product un : unique) {
                unidetails = unidetails + "[NAME: " + un.getName() + " SIZE " + un.getSize() + " ]";
            }
        }

        if (duplicate.size() > 0) {
            //throw new IllegalStateException("product duplicated " + duplidetails + " " + "uniqueElementAdded " + unidetails);
        }

        return duplicate; 
    }

    public List<Product> getAllProduct() {
        return productDao.getAllProduct();
    }

	
}
