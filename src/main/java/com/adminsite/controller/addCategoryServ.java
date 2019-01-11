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
 * Servlet implementation class addCategoryServ
 */
@WebServlet("/addCategoryServ")
public class addCategoryServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoryDao dao = new CategoryDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCategoryServ() {
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
		String type = request.getParameter("type");
		String description = request.getParameter("description");
		
		if(!type.isEmpty() && !description.isEmpty()){
			try {
				dao.AddCategory(new CategoryEntity(type,description));
				//request.getRequestDispatcher("CategoryServ").forward(request, response);
				 response.sendRedirect(request.getContextPath() + "/CategoryServ");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
//			request.getRequestDispatcher(request.getContextPath() + "/CategoryServ").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/CategoryServ");
		}
	}

}
