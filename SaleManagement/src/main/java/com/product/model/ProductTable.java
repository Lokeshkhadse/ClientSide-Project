package com.product.model;

public class ProductTable {
	private int id;
	private String productName;
	private double mrp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getMrp() {
		return mrp;
	}
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}
	
	public ProductTable(int id, String productName, double mrp) {
		super();
		this.id = id;
		this.productName = productName;
		this.mrp = mrp;
	}
	public ProductTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
