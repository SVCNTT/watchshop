package com.haipham.connection;

import java.sql.SQLException;
import java.util.List;

import com.haipham.model.CartDetail;
import com.haipham.model.CartInfos;
import com.haipham.model.Category;
import com.haipham.model.Product;

public interface ProductDAO {

	
	
	//Show products
	public List<Product> getList();
	public Product getProduct(int id);
	public boolean deleteCart(int id) throws SQLException; 
	
	public void addCart(CartInfos c);
	public void addCartDetail(CartDetail cd);
	public List<CartInfos> getListCart();
	
	
	public List<Product> getProductString(String name);
	public List<Product> getProductcat(String category);
	public Product getsingleProduct(String id);
	public List<Category> getCategoryType();
}
