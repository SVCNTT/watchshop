package com.adminsite.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.adminsite.entity.OrderDetailEntity;


public class OrderDetailDao {
	public List<OrderDetailEntity> LoadSingleProduct(int id) throws ClassNotFoundException, SQLException{
		List<OrderDetailEntity> list = new ArrayList<OrderDetailEntity>();
		ConnectDB db = new ConnectDB();
		db.connect();
		try {
			String sql = "Select * From product, cart_detail Where product_id = product.ID and cart_id =" + id;
			ResultSet rs = db.st.executeQuery(sql);
			//System.out.print(rs.getString("Username"));
			while (rs.next()){
				OrderDetailEntity p = new OrderDetailEntity();	
				p.setId(rs.getInt("id"));
				p.setProduct_id(rs.getString("product.Name"));
				p.setOrder_id(rs.getInt("cart_id"));
				p.setQuantity(rs.getInt("quantity"));
				p.setPrice(rs.getInt("price"));
				list.add(p);				
			}
			rs.close();
			db.st.close();
			db.con.close();
			
		} catch (Exception e){
			e.printStackTrace();
		}
	return list;
	}
}
