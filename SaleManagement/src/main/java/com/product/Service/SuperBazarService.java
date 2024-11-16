package com.product.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.Dto.SuperBazarDto;
import com.product.Exception.StoreNotFoundException;
import com.product.dao.SuperBazarDao;
import com.product.model.Sale;
import com.product.model.Store;

@Service
public class SuperBazarService {
	
	@Autowired
	private SuperBazarDao superBazarDao;


	public List<SuperBazarDto> getAllSales(int id) {
		
	    Store store = superBazarDao.findbyid(id); //if present then throw store doesnot exist if not present then it will go on next step

	    return superBazarDao.getSales(id);
	}


	public List<SuperBazarDto> getSalesByDateAndS_id(Date date, int id) {
		 Store store = superBazarDao.findbyid(id); //if present then throw store doesnot exist if not present then it will go on next step
//		 Sale sale = superBazarDao.findbyDate(date);
		 

//		return superBazarDao.getSalesByDateAndS_id(date , id);
		 
          if( superBazarDao.getSalesByDateAndS_id(date , id).isEmpty()) {    //if list empty that's means that day sale doesnot purchased
  	        throw new StoreNotFoundException("date does't exist " + date);

          }
  		return superBazarDao.getSalesByDateAndS_id(date , id);
 

		 
		 
	}
	
	

}
