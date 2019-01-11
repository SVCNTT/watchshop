package com.haipham.connection;

import java.sql.SQLException;
import java.util.List;

import com.haipham.model.CommentModel;
import com.haipham.model.Product;

public interface CmtDAO {

	public void addComment(CommentModel c) ;
	public List<CommentModel> getComment(int ID);
	public void DeleteCMT(int id);
}