package com.haipham.model;

public class Category {
	private int ID;
	private String Type;
	private String description;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category(int iD, String type, String description) {
		super();
		ID = iD;
		Type = type;
		this.description = description;
	}
	
	
}
