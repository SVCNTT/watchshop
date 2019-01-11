package com.haipham.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haipham.connection.CmtImpl;
import com.haipham.model.*;

/**
 * Servlet implementation class Comment
 */
@WebServlet("/CommentServlet")

public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CmtImpl cmtImpl = new CmtImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
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
		String status = ""+request.getParameter("submit");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		 
		int ID = Integer.parseInt(""+request.getParameter("ID"));
		String url = "";
		if(status.equals("Comment")){
			HttpSession session = request.getSession() ;
			String username= ""+session.getAttribute("username");
		
			String cmt = ""+request.getParameter("cmt");
		
			CommentModel c = new CommentModel(username, cmt,"","",ID);		
			cmtImpl.addComment(c);
		
			url = "/single.jsp?product_id="+ID;
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request,response);
		}
		if(status.equals("delete")){
			int idcmt = Integer.parseInt(""+request.getParameter("idcmt"));
			cmtImpl.DeleteCMT(idcmt);
			url = "/single.jsp?product_id="+ID;
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request,response);
		}
		
	
	}

}
