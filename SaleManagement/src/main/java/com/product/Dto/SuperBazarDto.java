package com.product.Dto;

public class SuperBazarDto {
	
	private String productName;
	private int quantity;
	private double mrp;
	private double amount;
	
	
	
	

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
     
	

	public SuperBazarDto(String productName, int quantity, double mrp, double amount) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.mrp = mrp;
		this.amount = amount;
	}

	public SuperBazarDto() {
		super();
	}
	
	

}
