package com.product.model;

public class Product {
	
	private int id;
	private String name;
	private int size;
	private String unit;
	private int price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Product(int id, String name, int size, String unit, int price) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.unit = unit;
		this.price = price;
	}
	public Product() {
		super();
	}
	
	
	

}
