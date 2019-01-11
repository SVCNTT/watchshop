package com.haipham.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haipham.connection.ProductImpl;
import com.haipham.model.Cart;
import com.haipham.model.Product;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Cart> cart = new ArrayList<Cart>();
	private ProductImpl p = new ProductImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
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
		String command = request.getParameter("command");
		String product_id = request.getParameter("product_id");
		String url = (String) request.getAttribute("javax.servlet.forward.request_uri");
		System.out.println("URL ra cai deo gi "+url);
		try {
			HttpSession session = request.getSession();
		if (command.equals("addCart")){
			Product p = new Product(Integer.parseInt(product_id),"",0,0.0,"");
			/*System.out.println(p.getProduct_id());*/
			addToCart(p);
			
			session.setAttribute("cart", cart);
			System.out.println("Session cua Cart : "+session.getId());
			response.sendRedirect("men.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			 response.getWriter().print(e.getMessage());
		}
			}
	//them san pham vao gio hang
	public String addToCart(Product p){
		for(Cart item : cart){
			if(item.getP().getID() == p.getID()){
				item.setQuantity(item.getQuantity()+1);
				
				return "cart";
			}}
			Cart c = new Cart();
			c.setP(p);
			c.setQuantity(1);
			cart.add(c);
			return "cart";
	}
}
