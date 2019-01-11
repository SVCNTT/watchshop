package com.haipham.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.haipham.model.CommentModel;
import com.mysql.jdbc.PreparedStatement;
public class CmtImpl implements CmtDAO {
	public void addComment(CommentModel c) {
		Connection con = DBConnection.getConnection();
		
		PreparedStatement st;
		try {
			
			String sql = "insert into comment(username,content,date,ID) values ('"+c.getName()+"','"+c.getContent()+"',NOW(),"+c.getID()+")";
			st = (PreparedStatement) con.prepareStatement(sql);
			st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public List<CommentModel> getComment(int ID) {
		
		Connection con = DBConnection.getConnection();
		String sql = "select * from comment where id ='"+ID+"'";
		List<CommentModel> list = new ArrayList<CommentModel>();
		
		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				String Name = rs.getString(1);
				String Content = rs.getString(2);
				String Date = rs.getString(3);
				String idcmt = ""+rs.getInt(4);
				list.add(new CommentModel(Name,Content,Date,idcmt,ID));
			}
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}

	
	public void DeleteCMT(int id) {
		Connection con = DBConnection.getConnection();
		String sql = "DELETE FROM comment WHERE idcmt="+id;
		PreparedStatement st;
		try {
			
			
			st = (PreparedStatement) con.prepareStatement(sql);
			st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	}
