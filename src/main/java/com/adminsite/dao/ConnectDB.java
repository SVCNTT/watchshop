package com.adminsite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
	public String url,username,password;
	public Connection con = null;
	public Statement st;
	public void connect() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		url = "jdbc:mysql://localhost:3306/shoppingonline";
		username = "root";
		password = "";
	
		con = DriverManager.getConnection(url, username, password);
		st = con.createStatement();
		
	}
}
