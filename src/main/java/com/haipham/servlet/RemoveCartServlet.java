package com.haipham.servlet;

import java.awt.event.ItemEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haipham.model.Cart;
import com.haipham.model.Product;

/**
 * Servlet implementation class RemoveCartServlet
 */
@WebServlet("/RemoveCartServlet")
public class RemoveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Cart> cart = new ArrayList<Cart>();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCartServlet() {
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		String action = request.getParameter("action");
		int id_pro = Integer.parseInt(request.getParameter("id_pro"));
		/*System.out.println("id_pro la : "+id_pro);*/
		List<Cart> list = (List<Cart>) session.getAttribute("cart");
		
		int position = 0;
		for (int i=0;i< list.size();i++){
			if (id_pro == list.get(i).getP().getID()){
				position = i;
				break;
			}
		}
		list.remove(position);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/checkout.jsp");
		rd.forward(request, response);
		/*for (Cart cart : list) {
			System.out.println("id lay ve la "+cart.getP().getID());
			System.out.println("size la "+list.size());
			for(int i=0;i<list.size();i++){
				if (id_pro == cart.getP().getID()){
					list.remove(new Cart(new Product(id_pro, "", 0, 0.0, ""),0));
					response.sendRedirect("checkout.jsp");
					System.out.println("size sau khi xoa "+list.size());
			}
		}*/
			
		}
		/*for (Cart cart : list) {
			System.out.println("id sau khi xoa "+cart.getP().getID());
		}*/
		/*List<Cart> list = (List<Cart>) session.getAttribute("cart");
		Product p = new Product(Integer.parseInt(id_pro),"",0,0.0,"");
		getCart(p,id_pro);
		for(int i = 0 ; i < list.size() ; i ++){
			System.out.println(list.get(i).getP().getName());}
		if(action.equals("remove")){
	
			Cart c = new Cart(new Product(Integer.parseInt(id_pro), "", 0, 0.0, ""),0);
	
			if(cart.contains(c))
				{
				cart.remove(c);
				}
			
			response.sendRedirect("checkout.jsp");
		}
		
	}
	
	public String getCart(Product p,String id_pro){
		for(Cart item : cart){
			if(item.getP().getID() == p.getID()){
				item.setQuantity(item.getQuantity()+1);
				
				return "cart";
			}}
		Cart c = new Cart(new Product(Integer.parseInt(id_pro), "", 0, 0.0, ""),0);
		cart.add(c);
		return "cart";
		}*/
			
		
	
	}

