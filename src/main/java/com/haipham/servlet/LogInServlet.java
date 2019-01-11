package com.haipham.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.adminsite.dao.UserDao;
import com.haipham.connection.AccountImpl;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private AccountImpl accountImpl = new AccountImpl();
       private UserDao dao = new UserDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
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
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = "";
		
		String str = "";
		
		if (username.equals("") || password.equals("")){
			str ="Plank space is not allowed";
		}else{
			if (accountImpl.checkLogin(username, password) == false){
				str = "Username or password is not correct";
			}
		}
		
		if(str.length()>0){
			// error happend
			request.setAttribute("str", str);
		}
		
		String url ="";
		
		try {
			if (str.length() == 0) {
				// successfully
				url = "/index.jsp";
				accountImpl.checkLogin(username, password);
				HttpSession sessionUser = request.getSession();
				sessionUser.setAttribute("username", username);
				role = dao.LoadRole(username);
				HttpSession sessionRole = request.getSession();
				sessionRole.setAttribute("role", role);
//				System.out.print(role);
//				request.setAttribute("role", role);
				System.out.println("Session cua username " + sessionUser.getId());
			} else {
				url = "/login.jsp";
			}
			RequestDispatcher rd = getServletContext()
					.getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/login.jsp");
		}
	}
			} 


