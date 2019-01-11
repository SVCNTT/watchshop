package com.adminsite.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class controller
 */
@WebServlet("/controller")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controller() {
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
		String action = request.getParameter("action");
		switch(action){
			case "account":
				request.getRequestDispatcher("UserServ").forward(request, response);
				break;
			case "product":
				request.getRequestDispatcher("ProductServ").forward(request, response);
				break;	
			case "category":
				request.getRequestDispatcher("CategoryServ").forward(request, response);
				break;	
			case "order":
				request.getRequestDispatcher("OrderServ").forward(request, response);
				break;
			case "orderDetail":
				request.getRequestDispatcher("OrderDetailServ").forward(request, response);
				break;
		}
	}

}
