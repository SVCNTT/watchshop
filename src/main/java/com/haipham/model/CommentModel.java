package com.haipham.model;

public class CommentModel {
	private String Name;
	private String Content;
	private String Date;
	private int ID;
	private String idcmt;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public int getID() {
		return ID;
	}
	public String getIdcmt() {
		return idcmt;
	}
	public void setIdcmt(String idcmt) {
		this.idcmt = idcmt;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		this.Content = content;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		this.Date = date;
	}
	
	public CommentModel(String name, String content, String date,  String idcmt ,int iD) {
		super();
		Name = name;
		Content = content;
		Date = date;
		ID = iD;
		this.idcmt = idcmt;
	}
	
}
