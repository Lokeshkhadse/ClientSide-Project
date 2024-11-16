package com.product.Dto;

import java.util.Date;
import java.util.List;

public class SaleDateTableDto {
	
	private Date s_date;
	
	private List<SaleTableDto> salesTableDto;

	public Date getS_date() {
		return s_date;
	}

	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}

	public List<SaleTableDto> getSalesTableDto() {
		return salesTableDto;
	}

	public void setSalesTableDto(List<SaleTableDto> salesTableDto) {
		this.salesTableDto = salesTableDto;
	}

	
	
	

}
