package com.haipham.connection;

import java.sql.SQLException;
import java.util.List;

import com.haipham.model.Account;

public interface AccountDAO {
	public void showAccount() throws SQLException, ClassNotFoundException;

	public List<Account> getList();

	public void addAccount(Account a);

	public String getRole(String username);
	
	public boolean checkUser(String username);

	public boolean checkLogin(String username , String password);
}
