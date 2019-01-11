package com.adminsite.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.adminsite.dao.UserDao;
import com.adminsite.entity.UserEntity;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao = new UserDao();
	private String check;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		int flag = 0;
		List<UserEntity> list;
		try {
			list = dao.UserAccount();
			for(int i = 0 ; i < list.size() ; i ++){
				if(username.equals(list.get(i).getUsername()) && password.equals(list.get(i).getPassword())){
					flag = 1;
					break;
				}else
					flag = 0;
			}
			if(flag == 1){
				check = "valid";
				session.setAttribute("user", username);
			}else{
				check = "fail";
			}
			response.setContentType("text/plain");
			response.getWriter().write(check);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
