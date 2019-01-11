package com.haipham.model;

public class CartInfos {
private int id;
private int id_customer;
private double price_sum;
private String address;
private String date_delivery;
private int status;
private String phone;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getId_customer() {
	return id_customer;
}
public void setId_customer(int id_customer) {
	this.id_customer = id_customer;
}
public double getPrice_sum() {
	return price_sum;
}
public void setPrice_sum(double price_sum) {
	this.price_sum = price_sum;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getDate_delivery() {
	return date_delivery;
}
public void setDate_delivery(String date_delivery) {
	this.date_delivery = date_delivery;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}

public CartInfos() {
	
}
public CartInfos(int id, int id_customer, double price_sum, String address,
		String date_delivery, int status, String phone) {
	
	this.id = id;
	this.id_customer = id_customer;
	this.price_sum = price_sum;
	this.address = address;
	this.date_delivery = date_delivery;
	this.status = status;
	this.phone = phone;
}

}
