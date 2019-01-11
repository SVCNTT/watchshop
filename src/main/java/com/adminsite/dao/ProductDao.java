package com.adminsite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.adminsite.entity.ProductEntity;

public class ProductDao {
	public List<ProductEntity> LoadProduct() throws ClassNotFoundException, SQLException{
		List<ProductEntity> list = new ArrayList<ProductEntity>();
		ConnectDB db = new ConnectDB();
		db.connect();
		try {
			String sql = "SELECT * FROM product";
			ResultSet rs = db.st.executeQuery(sql);
			//System.out.print(rs.getString("Username"));
			while (rs.next()){
				ProductEntity p = new ProductEntity();	
				p.setId(rs.getInt("ID"));
				p.setName((rs.getString("Name")));
				p.setCategoryID((rs.getInt("CategoryID")));
				p.setPrice(rs.getInt("Price"));
				p.setImage(rs.getString("Image"));
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
	
	public void AddProduct(ProductEntity p) throws ClassNotFoundException, SQLException {
		ConnectDB db = new ConnectDB();
		db.connect();
		
//		ProductEntity p = new ProductEntity();
//		
//		p.setName(name);
//		p.setCategoryID(category);
//		p.setPrice(price);
//		p.setImage(image);
		
		String sql = "INSERT INTO product (Name, CategoryID, Price, Image) VALUES (?,?,?,?)";
		PreparedStatement pr = db.con.prepareStatement(sql);

		pr.setString(1, p.getName());
		pr.setInt(2, p.getCategoryID());
		pr.setInt(3, p.getPrice());
		pr.setString(4, p.getImage());
		
		pr.addBatch();
		pr.executeBatch();

		pr.close();
		db.con.close();
	}
	
	public void deleteProduct(int idToDelete){
		ConnectDB db = new ConnectDB();
		
		try {
			db.connect();
			
			String sql = "DELETE FROM product WHERE ID = " + idToDelete;
			db.st.executeUpdate(sql);
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	public List<ProductEntity> LoadSingleProduct(int id) throws ClassNotFoundException, SQLException{
		List<ProductEntity> list = new ArrayList<ProductEntity>();
		ConnectDB db = new ConnectDB();
		db.connect();
		try {
			String sql = "SELECT * FROM product WHERE ID = " + id;
			ResultSet rs = db.st.executeQuery(sql);
			//System.out.print(rs.getString("Username"));
			while (rs.next()){
				ProductEntity p = new ProductEntity();	
				p.setId(rs.getInt("ID"));
				p.setName((rs.getString("Name")));
				p.setCategoryID((rs.getInt("CategoryID")));
				p.setPrice(rs.getInt("Price"));
				p.setImage(rs.getString("Image"));
				
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
	
	
	public void EditProduct(int id, String name,int cateID, int price, String image) throws ClassNotFoundException, SQLException{
		ConnectDB db = new ConnectDB();
		db.connect();
		try {
			String sql = "UPDATE product SET Name = '"+name+"',CategoryID = '"+cateID+"',Price='"+price+"', Image='"+image+"' WHERE ID = " + id;
			db.st.executeUpdate(sql);
			
			db.st.close();
			db.con.close();
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
