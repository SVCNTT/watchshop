package com.adminsite.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adminsite.dao.OrderDao;

/**
 * Servlet implementation class inactiveOrder
 */
@WebServlet("/editOrderStatus")
public class editOrderStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OrderDao dao = new OrderDao(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editOrderStatus() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			int status = dao.LoadSingleOrder(id).getStatus();
			dao.editStatus(id,status);
			response.sendRedirect(request.getContextPath() + "/OrderServ");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
