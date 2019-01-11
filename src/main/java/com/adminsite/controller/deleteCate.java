package com.adminsite.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adminsite.dao.CategoryDao;

/**
 * Servlet implementation class deleteCate
 */
@WebServlet("/deleteCate")
public class deleteCate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoryDao dao = new CategoryDao(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteCate() {
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
		int id = Integer.parseInt(request.getParameter("id"));	
		dao.deleteCate(id);
		response.sendRedirect(request.getContextPath() + "/CategoryServ");
	}

}
