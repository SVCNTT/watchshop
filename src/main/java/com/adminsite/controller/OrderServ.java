package com.adminsite.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adminsite.dao.OrderDao;
import com.adminsite.dao.UserDao;
import com.adminsite.entity.OrderEntity;
import com.adminsite.entity.UserEntity;

/**
 * Servlet implementation class OrderServ
 */
@WebServlet("/OrderServ")
public class OrderServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OrderDao dao = new OrderDao();
    private UserDao user_dao = new UserDao();
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServ() {
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
		List<OrderEntity> list ;
		try {
			list = dao.LoadOrder();
			request.setAttribute("OrderList", list);
			request.getRequestDispatcher("order.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
