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
import com.adminsite.entity.CategoryEntity;

/**
 * Servlet implementation class CategoryServ
 */
@WebServlet("/CategoryServ")
public class CategoryServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoryDao dao = new CategoryDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServ() {
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
		try {
			list = dao.LoadCategory();
			request.setAttribute("CateList", list);
			request.getRequestDispatcher("category.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
