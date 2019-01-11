package com.haipham.connection;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DBConnection {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/shoppingonline", "root", "123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void main(String[] args) {
		System.out.println("Connect to " + getConnection() + " successfully");
	}

}
