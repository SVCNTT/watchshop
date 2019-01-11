package com.adminsite.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adminsite.dao.OrderDetailDao;
import com.adminsite.dao.ProductDao;
import com.adminsite.entity.OrderDetailEntity;

/**
 * Servlet implementation class OrderDetailServ
 */
@WebServlet("/OrderDetailServ")
public class OrderDetailServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OrderDetailDao dao = new OrderDetailDao();
    private OrderDetailEntity od = new OrderDetailEntity();
    private ProductDao p_dao = new ProductDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetailServ() {
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
		int order_id = Integer.parseInt(request.getParameter("id"));
//		System.out.println(order_id);
		List<OrderDetailEntity> od = new ArrayList<OrderDetailEntity>();
		try {
			
			od = dao.LoadSingleProduct(order_id);
			request.setAttribute("OrderDetail", od);
			request.getRequestDispatcher("order_detail.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
