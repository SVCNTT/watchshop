package com.adminsite.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.adminsite.entity.OrderEntity;

public class OrderDao {
	public List<OrderEntity> LoadOrder() throws ClassNotFoundException, SQLException{
		List<OrderEntity> list = new ArrayList<OrderEntity>();
		ConnectDB db = new ConnectDB();
		db.connect();
		try {
			String sql = "SELECT * FROM cart";
			ResultSet rs = db.st.executeQuery(sql);
			while (rs.next()){
				OrderEntity o = new OrderEntity();	
				o.setId(rs.getInt("id"));
				o.setId_customer(rs.getInt("id_customer"));
				o.setTotal_price(rs.getInt("price_sum"));
				o.setAddress(rs.getString("address"));
				o.setDate(rs.getString("date_delivery"));
				o.setStatus(rs.getInt("status"));
				list.add(o);				
			}
			rs.close();
			db.st.close();
			db.con.close();
			
		} catch (Exception e){
			e.printStackTrace();
		}
	return list;
	}
	
	public void deleteOrder(int idToDelete){
		ConnectDB db = new ConnectDB();		
		try {
				db.connect();
				
				String sql = "DELETE FROM cart WHERE ID = " + idToDelete;
				db.st.executeUpdate(sql);
				
				
				
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
	
	public void deleteOrder_IDCustomer(int idToDelete){
		ConnectDB db = new ConnectDB();		
		try {
				db.connect();
				
				String sql = "DELETE FROM cart WHERE id_customer = " + idToDelete;
				db.st.executeUpdate(sql);
				
				
				
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
	
	public OrderEntity LoadSingleOrder(int id) throws ClassNotFoundException, SQLException{
		//List<ProductEntity> list = new ArrayList<ProductEntity>();
		OrderEntity o = new OrderEntity();
		ConnectDB db = new ConnectDB();
		db.connect();
		try {
			String sql = "SELECT * FROM cart WHERE ID = " + id;
			ResultSet rs = db.st.executeQuery(sql);
			//System.out.print(rs.getString("Username"));
			while (rs.next()){
					
				o.setId(rs.getInt("id"));
				o.setId_customer(rs.getInt("id_customer"));
				o.setTotal_price(rs.getInt("price_sum"));
				o.setAddress(rs.getString("address"));
				o.setDate(rs.getString("date_delivery"));
				o.setStatus(rs.getInt("status"));
				
				//list.add(p);				
			}
			rs.close();
			db.st.close();
			db.con.close();
			
		} catch (Exception e){
			e.printStackTrace();
		}
	return o;
	}
	
	public void editStatus(int id, int status) throws ClassNotFoundException, SQLException{
		ConnectDB db = new ConnectDB();
		db.connect();
		String sql;
		try {
			if(status == 1){
				sql = "UPDATE cart SET status = 0 WHERE ID = " + id;
			}else{
				sql = "UPDATE cart SET status = 1 WHERE ID = " + id;
			}
			db.st.executeUpdate(sql);
			
			db.st.close();
			db.con.close();
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
}
