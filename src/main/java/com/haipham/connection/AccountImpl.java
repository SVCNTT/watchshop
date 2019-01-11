package com.haipham.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.haipham.model.Account;
import com.mysql.jdbc.PreparedStatement;

public class AccountImpl implements AccountDAO {
	@Override
	public void showAccount() throws SQLException, ClassNotFoundException {
		Connection con = DBConnection.getConnection();

		Statement st = con.createStatement();

		String sql = "Select id,username,fullname from account";

		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			int acoountID = rs.getInt(1);
			String accountName = rs.getString(2);
			String accountFull = rs.getString(3);

			/*
			 * System.out.println("-------");
			 * System.out.println("Account ID = "+ acoountID);
			 * System.out.println("Username = "+accountName);
			 * System.out.println("Fullname = "+accountFull);
			 */

		}

		con.close();

	}

	@Override
	public List<Account> getList() {
		Connection con = DBConnection.getConnection();

		String sql = "Select id,username,fullname from account";
		List<Account> list = new ArrayList<Account>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int account_id = rs.getInt(1);

				String accountName = rs.getString(2);
				String accountFull = rs.getString(3);
				list.add(new Account(account_id, accountName, null,
						accountFull, null, null));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void addAccount(Account a) {
		Connection con = DBConnection.getConnection();
		String sql = "insert into account value (?,?,?,?,?,?)";
		PreparedStatement st;
		try {

			st = (PreparedStatement) con.prepareStatement(sql);
			st.setInt(1, a.getId());
			st.setString(2, a.getUsername());
			st.setString(3, a.getPassword());
			st.setString(4, a.getFullname());
			st.setString(5, a.getEmail());
			st.setString(6, a.getRole());
			st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean checkUser(String username) {
		Connection con = DBConnection.getConnection();
		String sql = "select * from account where username='" + username + "'";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				con.close();
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean checkLogin(String username, String password) {
		
		Connection con = DBConnection.getConnection();
		String sql = "select * from account where username='" + username + "'"+" and password='"+password+"'";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				con.close();
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public String getRole(String username) {
		Connection con = DBConnection.getConnection();
		String sql = "select role from account where username ='"+username+"'";
		String role ="";
		PreparedStatement ps;
		try{
			ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				role = rs.getString("role");
			}
			con.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return role;
		
	}
	public static void main(String[] args) throws SQLException,
			ClassNotFoundException {
		AccountImpl acc = new AccountImpl();
		String username ="haiph";
		
		String role= acc.getRole(username);
		System.out.println("role la "+role);
		
		// add account

	}



	

	

}
