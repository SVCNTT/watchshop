package com.adminsite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.adminsite.dao.ConnectDB;
import com.adminsite.entity.UserEntity;

public class UserDao {
	public List<UserEntity> UserAccount() throws ClassNotFoundException, SQLException{
		List<UserEntity> list = new ArrayList<UserEntity>();
		ConnectDB db = new ConnectDB();
		db.connect();
		try {
			String sql = "SELECT * FROM account";
			ResultSet rs = db.st.executeQuery(sql);
			//System.out.print(rs.getString("Username"));
			while (rs.next()){
				UserEntity user = new UserEntity();	
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setEmail(rs.getString("email"));	
				user.setRole(rs.getString("role"));
				list.add(user);				
			}
			rs.close();
			db.st.close();
			db.con.close();
			
		} catch (Exception e){
			e.printStackTrace();
		}
	return list;
	}
	
	public void AddUser(UserEntity user) throws ClassNotFoundException, SQLException {
		ConnectDB db = new ConnectDB();
		db.connect();
		
		
		String sql = "INSERT INTO account (fullname, username, password, email, role) VALUES (?,?,?,?,?)";
		PreparedStatement p = db.con.prepareStatement(sql);

		p.setString(1, user.getUsername());
		p.setString(2, user.getPassword());
		p.setString(3, user.getFullname());
		p.setString(4, user.getEmail());
		p.setString(5, user.getRole());
		
		p.addBatch();
		p.executeBatch();

		p.close();
		db.con.close();
	}
	
	public void DeleteUser(int idToDelete){
		ConnectDB db = new ConnectDB();
		
		try {
			db.connect();
			
			String sql = "DELETE FROM account WHERE id = " + idToDelete;
			db.st.executeUpdate(sql);
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public List<UserEntity> LoadAccount(int id) throws ClassNotFoundException, SQLException{
		List<UserEntity> list = new ArrayList<UserEntity>();
		ConnectDB db = new ConnectDB();
		db.connect();
		try {
			String sql = "SELECT * FROM account WHERE id = " + id;
			ResultSet rs = db.st.executeQuery(sql);
			//System.out.print(rs.getString("Username"));
			while (rs.next()){
				UserEntity user = new UserEntity();	
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setEmail(rs.getString("email"));
				user.setRole(rs.getString("role"));
				list.add(user);				
			}
			rs.close();
			db.st.close();
			db.con.close();
			
		} catch (Exception e){
			e.printStackTrace();
		}
	return list;
	}
	
	public String LoadRole(String username) throws ClassNotFoundException, SQLException{
		ConnectDB db = new ConnectDB();
		db.connect();
		String role = "";
		try {
			String sql = "SELECT * From account WHERE username = '" + username+"'";
			ResultSet rs = db.st.executeQuery(sql);
			
			//System.out.print(rs.getString("Username"));
			while (rs.next()){	
				role = rs.getString("role");			
			}
			rs.close();
			db.st.close();
			db.con.close();
			
		} catch (Exception e){
			e.printStackTrace();
		}
	return role;
	}
	
	public void EditAccount(int id, String fname, String password, String role) throws ClassNotFoundException, SQLException{
		ConnectDB db = new ConnectDB();
		db.connect();
//		String sql2 = "UPDATE account SET password = '"+password+"',fullname = '"+fname+"'  WHERE id = " + id;
		try {
			String sql = "UPDATE account SET password = '"+password+"',fullname = '"+fname+"',role = '"+role+"'  WHERE id = " + id;
			db.st.executeUpdate(sql);
			
			db.st.close();
			db.con.close();
			
		} catch (Exception e){
			e.printStackTrace();
		}
//		return sql2;
	}
}
