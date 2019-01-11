package com.adminsite.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adminsite.dao.UserDao;
import com.adminsite.entity.UserEntity;

/**
 * Servlet implementation class AddUserServ
 */
@WebServlet("/AddUserServ")
public class AddUserServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao dao = new UserDao();
    private UserEntity user;
    int count = 0;
    String check;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServ() {
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
		String fullname = request.getParameter("fullname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String role = request.getParameter("role");
		
		
		try {
			List<UserEntity> list = dao.UserAccount();
			for(int i = 0 ; i < list.size() ; i ++){
				if(username.equals(list.get(i).getUsername()) || email.equals(list.get(i).getEmail())){
					count ++;
				}
			}
			if(fullname.length() >= 6 && count == 0 && password.length() >= 6){
				dao.AddUser(new UserEntity(fullname, username, password, email, role));
				//response.getWriter().write("ok");
				response.sendRedirect(request.getContextPath() + "/UserServ");
//				request.getRequestDispatcher("UserServ").forward(request, response);
			}else{
//				int id = Integer.parseInt(request.getParameter("idUser"));
//				String s = dao.EditAccount(id, fullname, password);
//				response.getWriter().write(s);
				response.sendRedirect(request.getContextPath() + "/UserServ");
//				request.getRequestDispatcher("UserServ").forward(request, response);
			}

			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
