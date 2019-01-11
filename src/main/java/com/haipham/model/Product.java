package com.haipham.model;

public class Product {
private int ID;
private String Name;
private int CategoryID;
private double Price;
private String Image;
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public int getCategoryID() {
	return CategoryID;
}
public void setCategoryID(int categoryID) {
	CategoryID = categoryID;
}
public double getPrice() {
	return Price;
}
public void setPrice(double price) {
	Price = price;
}
public String getImage() {
	return Image;
}
public void setImage(String image) {
	Image = image;
}
public Product(int iD, String name, int categoryID, double price, String image) {
	super();
	ID = iD;
	Name = name;
	CategoryID = categoryID;
	Price = price;
	Image = image;
}
public Product() {
	super();
}



}
