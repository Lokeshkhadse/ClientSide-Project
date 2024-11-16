package com.product.Dto;

import java.util.Date;

public class SaleTableDto {
	
	private int p_id;
	private int quantity;
	private int s_id;
	private double mrp;
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public double getMrp() {
		return mrp;
	}
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}
	public SaleTableDto(int p_id, int quantity, int s_id, double mrp) {
		super();
		this.p_id = p_id;
		this.quantity = quantity;
		this.s_id = s_id;
		this.mrp = mrp;
	}
	public SaleTableDto() {
		super();
	}
	
	

}
