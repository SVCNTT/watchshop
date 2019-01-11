package com.adminsite.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adminsite.dao.CategoryDao;

/**
 * Servlet implementation class editCategoryServ
 */
@WebServlet("/editCategoryServ")
public class editCategoryServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoryDao dao = new CategoryDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editCategoryServ() {
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
				int id = Integer.parseInt(request.getParameter("idCate"));
				dao.EditCategory(id, type, description);
				response.sendRedirect(request.getContextPath() + "/CategoryServ");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//response.getWriter().write("ok");
			
//			request.getRequestDispatcher("UserServ").forward(request, response);
		}else{
			
//			response.getWriter().write(s);
			response.sendRedirect(request.getContextPath() + "/CategoryServ");
//			request.getRequestDispatcher("UserServ").forward(request, response);
		}
	}

}
