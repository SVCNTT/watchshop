package com.adminsite.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adminsite.dao.CategoryDao;
import com.adminsite.dao.ProductDao;
import com.adminsite.entity.CategoryEntity;
import com.adminsite.entity.ProductEntity;

/**
 * Servlet implementation class LoadCategory
 */
@WebServlet("/ProductServ")
public class ProductServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoryDao dao = new CategoryDao();
    private ProductDao pdao = new ProductDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CategoryEntity> list;
		List<ProductEntity> productList;
		try {
			list = dao.LoadCategory();
			productList = pdao.LoadProduct();
			request.setAttribute("CateList", list);
			request.setAttribute("ProductList", productList);
			//response.getWriter().write(list.get(0).getId());
			request.getRequestDispatcher("product.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
