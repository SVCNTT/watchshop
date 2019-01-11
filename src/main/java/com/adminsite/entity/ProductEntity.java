package com.adminsite.entity;

public class ProductEntity {
	private int id;
	private String name;
	private int category_id;
	private int price;
	private String image;
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
	public int getCategoryID() {
		return category_id;
	}
	public void setCategoryID(int category_id) {
		this.category_id = category_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public ProductEntity(String name, int category_id, int price, String image) {
		this.name = name;
		this.category_id = category_id;
		this.price = price;
		this.image = image;
	}
	
	public ProductEntity (){
		
	}
}
