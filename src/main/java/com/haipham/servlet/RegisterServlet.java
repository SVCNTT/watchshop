package com.haipham.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haipham.connection.AccountImpl;
import com.haipham.model.Account;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
private AccountImpl accountImpl = new AccountImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String confirmpassword = request.getParameter("confirmpassword");
	
		
		String str ="";
		String fullname ="";
		String role ="customer";
		
		if (username.equals("")||password.equals("")){
			str ="No Blank Space Allowed";
		} else {
			if (accountImpl.checkUser(username)==true){
				str ="Username is exist ";
			}if (password.equals(confirmpassword)){
				fullname = lname+" "+fname;
			}else{
				str ="Confirm Password does not match ";
			}
			}
		if (str.length()>0) { // co loi xay ra
			request.setAttribute("str", str);
		}
		
		
		String url = "";
		
		try {
			if (str.length()==0) { // Thanh cong
				accountImpl.addAccount(new Account(0, username, password,fullname,email,role));
				url = "/login.jsp";
			}
			else{
				url="/register.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request,response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/register.jsp");
		}
	}
}

		
		
		
		
	


