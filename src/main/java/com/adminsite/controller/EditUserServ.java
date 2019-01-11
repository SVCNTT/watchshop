package com.adminsite.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adminsite.dao.UserDao;

/**
 * Servlet implementation class EditUserServ
 */
@WebServlet("/EditUserServ")
public class EditUserServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao dao = new UserDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		if(fullname.length() >= 6 && password.length() >= 6){			
			try {
				int id = Integer.parseInt(request.getParameter("idUser"));
				dao.EditAccount(id, fullname, password, role);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//response.getWriter().write("ok");
			response.sendRedirect(request.getContextPath() + "/UserServ");
//			request.getRequestDispatcher("UserServ").forward(request, response);
		}else{
			
//			response.getWriter().write(s);
			response.sendRedirect(request.getContextPath() + "/UserServ");
//			request.getRequestDispatcher("UserServ").forward(request, response);
		}
	}

}
