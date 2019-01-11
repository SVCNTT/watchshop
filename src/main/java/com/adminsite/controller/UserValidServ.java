package com.adminsite.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adminsite.dao.*;
import com.adminsite.entity.UserEntity;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/UserValidServ")
public class UserValidServ extends HttpServlet {
	static String check;
	private static final long serialVersionUID = 1L;
    private UserDao dao = new UserDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserValidServ() {
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
		List<UserEntity> list;
		int flag = 0;
		try {		
			list = dao.UserAccount();
			for(int i = 0 ; i < list.size() ; i ++){
				if(username.equals(list.get(i).getUsername())){
					flag = 1;
					break;
				}else{
					flag = 0;
				}
			}
			if(flag == 1){
				check = "invalid";				
			}else{
				check = "valid";			
			}
			response.setContentType("text/plain");
			response.getWriter().write(check);
//		try{
//			List<UserEntity> list = dao.UserAccount();
//			for(int i = 0 ; i< list.size(); i ++){
//				response.getWriter().write(list.get(i).getUsername() + list.get(i).getEmail());
//		}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
