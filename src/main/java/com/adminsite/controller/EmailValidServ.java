package com.adminsite.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.adminsite.dao.UserDao;
import com.adminsite.entity.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmailValidServ
 */
@WebServlet("/EmailValidServ")
public class EmailValidServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String check;
    private UserDao dao = new UserDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailValidServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		List<UserEntity> list;
		int flag = 0;
		try {		
			list = dao.UserAccount();
			for(int i = 0 ; i < list.size() ; i ++){
				if(email.equals(list.get(i).getEmail())){
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
