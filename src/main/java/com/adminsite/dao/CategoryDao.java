package com.adminsite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.adminsite.entity.CategoryEntity;

public class CategoryDao {
	public List<CategoryEntity> LoadCategory() throws ClassNotFoundException, SQLException{
		List<CategoryEntity> list = new ArrayList<CategoryEntity>();
		ConnectDB db = new ConnectDB();
		db.connect();
		try {
			String sql = "SELECT * FROM category";
			ResultSet rs = db.st.executeQuery(sql);
			//System.out.print(rs.getString("Username"));
			while (rs.next()){
				CategoryEntity cate = new CategoryEntity();	
				cate.setId(rs.getInt("ID"));
				cate.setType(rs.getString("Type"));
				cate.setDescription(rs.getString("Description"));
				list.add(cate);				
			}
			rs.close();
			db.st.close();
			db.con.close();
			
		} catch (Exception e){
			e.printStackTrace();
		}
	return list;
	}
	
	public void AddCategory(CategoryEntity cate) throws ClassNotFoundException, SQLException {
		ConnectDB db = new ConnectDB();
		db.connect();
		
//		CategoryEntity cate = new CategoryEntity();
//		
//		cate.setType(type);
//		cate.setDescription(description);
		
		String sql = "INSERT INTO category (Type, Description) VALUES (?,?)";
		PreparedStatement p = db.con.prepareStatement(sql);

		p.setString(1, cate.getType());
		p.setString(2, cate.getDescription());
		
		p.addBatch();
		p.executeBatch();

		p.close();
		db.con.close();
	}
	
	public void deleteCate(int idToDelete){
		ConnectDB db = new ConnectDB();
		
		try {
			db.connect();
			
			String sql = "DELETE FROM category WHERE ID = " + idToDelete;
			db.st.executeUpdate(sql);
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public List<CategoryEntity> LoadSingleCate(int id) throws ClassNotFoundException, SQLException{
		List<CategoryEntity> list = new ArrayList<CategoryEntity>();
		ConnectDB db = new ConnectDB();
		db.connect();
		try {
			String sql = "SELECT * FROM category WHERE ID = " + id;
			ResultSet rs = db.st.executeQuery(sql);
			//System.out.print(rs.getString("Username"));
			while (rs.next()){
				CategoryEntity cate = new CategoryEntity();	
				cate.setId(rs.getInt("ID"));
				cate.setType((rs.getString("Type")));
				cate.setDescription((rs.getString("Description")));
				
				list.add(cate);				
			}
			rs.close();
			db.st.close();
			db.con.close();
			
		} catch (Exception e){
			e.printStackTrace();
		}
	return list;
	}
	
	public void EditCategory(int id, String type, String description) throws ClassNotFoundException, SQLException{
		ConnectDB db = new ConnectDB();
		db.connect();
		try {
			String sql = "UPDATE category SET Type = '"+type+"',Description = '"+description+"' WHERE ID = " + id;
			db.st.executeUpdate(sql);
			
			db.st.close();
			db.con.close();
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
