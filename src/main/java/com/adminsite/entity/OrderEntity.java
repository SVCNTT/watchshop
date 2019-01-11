package com.adminsite.entity;

public class OrderEntity {
	private int id;
	private int id_customer;
	private int total_price;
	private String address;
	private String date;
	private int status;
	
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
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public OrderEntity(int id, int id_customer, int total_price,
			String address, String date, int status) {
		super();
		this.id = id;
		this.id_customer = id_customer;
		this.total_price = total_price;
		this.address = address;
		this.date = date;
		this.status = status;
	}
	
	public OrderEntity(){
		
	}
	
	
}
