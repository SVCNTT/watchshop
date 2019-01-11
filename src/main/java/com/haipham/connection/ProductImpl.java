package com.haipham.connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;








import com.haipham.model.Account;
import com.haipham.model.CartDetail;
import com.haipham.model.CartInfos;
import com.haipham.model.Category;
import com.haipham.model.Product;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ProductImpl implements ProductDAO {

	
	@Override
	public List<Product> getProductString(String search) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		String sql = "select * from product where Name like'%"+search+"%'";
		List<Product> list = new ArrayList<Product>();
		
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				int product_id = rs.getInt(1);
				String product_name = rs.getString(2);
				int product_category = rs.getInt(3);
				double product_price = rs.getDouble(4);
				String product_image = rs.getString(5);
				list.add(new Product(product_id,product_name,product_category,product_price,product_image));
			}
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<Product> getProductcat(String search) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		String sql = "select * from product where categoryID ='"+search+"'";
		List<Product> list = new ArrayList<Product>();
		
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				int product_id = rs.getInt(1);
				String product_name = rs.getString(2);
				int product_category = rs.getInt(3);
				double product_price = rs.getDouble(4);
				String product_image = rs.getString(5);
				list.add(new Product(product_id,product_name,product_category,product_price,product_image));
			}
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return list;
	}

	public Product getsingleProduct(String id) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		String sql = "select * from product where ID ='"+id+"'";
		Product p = new Product();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				int product_id = rs.getInt(1);
				String product_name = rs.getString(2);
				int product_category = rs.getInt(3);
				double product_price = rs.getDouble(4);
				String product_image = rs.getString(5);
				p = new Product(product_id,product_name,product_category,product_price,product_image);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	@Override
	public List<Product> getList() {
		Connection con = DBConnection.getConnection();
		String sql = "select * from product";
		List<Product> list = new ArrayList<Product>();
				
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				int product_id = rs.getInt(1);
				String product_name = rs.getString(2);
				int product_category = rs.getInt(3);
				double product_price = rs.getDouble(4);
				String product_image = rs.getString(5);
				list.add(new Product(product_id,product_name,product_category,product_price,product_image));
			}
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		String sql = "select * from product where ID ='"+id+"'";
		Product p = new Product();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				int product_id = rs.getInt(1);
				String product_name = rs.getString(2);
				int product_category = rs.getInt(3);
				double product_price = rs.getDouble(4);
				String product_image = rs.getString(5);
				p = new Product(product_id,product_name,product_category,product_price,product_image);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public boolean deleteCart(int id) throws SQLException {
		 Connection con = DBConnection.getConnection();
		    String sql = "delete from product where id=?";
			   PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			    ps.setInt(1, id);
			    int change = 0;
			    change = ps.executeUpdate();
			    con.close();
			    if (change > 0) {
			        return true;
			    }else{
			    	return false;
			    }		
	}

	@Override
	public void addCart(CartInfos c) {
		
		Connection con = DBConnection.getConnection();
		String sql = "insert into cart value (?,?,?,?,?,?,?)";
		PreparedStatement st;
		try {

			st = (PreparedStatement) con.prepareStatement(sql);
			st.setInt(1, c.getId());
			st.setInt(2,c.getId_customer());
			st.setDouble(3, c.getPrice_sum());
			st.setString(4, c.getAddress());
			st.setString(5, c.getDate_delivery());
			st.setInt(6, c.getStatus());
			st.setString(7, c.getPhone());
			st.executeUpdate();
			
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void addCartDetail(CartDetail cd) {
		Connection con = DBConnection.getConnection();
		String sql = "insert into cart_detail value (?,?,?,?,?)";
		PreparedStatement st;
		
		
		try {

			st = (PreparedStatement) con.prepareStatement(sql);
			st.setInt(1,cd.getId());
			st.setInt(2,cd.getCart_id());
			st.setInt(3,cd.getProduct_id());
			st.setInt(4,cd.getQuantity());
			st.setDouble(5,cd.getPrice());

			st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public List<CartInfos> getListCart() {
		Connection con = DBConnection.getConnection();
		String sql = "select id from cart";
		List<CartInfos> list = new ArrayList<CartInfos>();
				
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				int cart_id = rs.getInt(1);
				list.add(new CartInfos(cart_id, 0, 0.0, "", "", 0,""));
				
			}
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return list;
	}
	public static void main(String[] args) {
		ProductImpl add = new ProductImpl();
		/*add.addCart(new CartInfos(0, 2, 202, "21ssaaa", "08/11/16", 1, "01223182222"));*/
	}

	public List<Category> getCategoryType() {
		// TODO Auto-generated method stub
		List<Category> list = new ArrayList<Category>();
		Connection con = DBConnection.getConnection();
		String sql = "select * from category ";
		Product p = new Product();
	
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				int id = Integer.parseInt(rs.getString("ID"));
				String type = rs.getString("Type");
				String des = rs.getString("Description");
				list.add(new Category(id,type,des));
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	

}
