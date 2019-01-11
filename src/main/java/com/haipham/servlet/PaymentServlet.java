package com.haipham.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haipham.connection.ProductImpl;
import com.haipham.model.Cart;
import com.haipham.model.CartDetail;
import com.haipham.model.CartInfos;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ProductImpl productImpl = new ProductImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
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
		ArrayList<Cart> cart = (ArrayList<Cart>) session.getAttribute("cart");
		
		String customerName = request.getParameter("customerName");
		ArrayList<CartInfos> ListCart = new ArrayList<CartInfos>();
		int id_customer = Integer.parseInt(request.getParameter("id_customer"));
		double price_sum = Double.parseDouble(request.getParameter("price_sum"));
		String customerAddress = request.getParameter("customerAddress");
		String date_delivery = dateTime();
		int status = 1;
		String customerPhone = request.getParameter("customerPhone");
		
		
		int count = Integer.parseInt(request.getParameter("count"));
		
		
		
		int ProductID = 0;
		int quantity_product = 0;
		double price_product = 0;
		
		int cart_id = 0;
		
		
	
		
		String url="/basket.jsp";
		String err ="";
		String thank="";
		String thank1="";
		String thank2="";
		String thank3="";
		if (customerName.equals("")||customerAddress.equals("")||customerPhone.equals("")){
			err ="No Blank Space Allowed";
		}
		
		try{
			if(err.length()>0){
				request.setAttribute("err", err);
			}
			if(err.length()==0){
				productImpl.addCart(new CartInfos(0, id_customer, price_sum, customerAddress, date_delivery, status, customerPhone));
									
				thank = customerName; 
				thank1 = customerAddress;
				thank2 = customerPhone;
				thank3 = date_delivery;
				request.setAttribute("thank", thank);
				request.setAttribute("thank1", thank1);
				request.setAttribute("thank2", thank2);
				request.setAttribute("thank3", thank3);
				
				ListCart = (ArrayList<CartInfos>) productImpl.getListCart();
				if(ListCart != null){
					for (CartInfos cartInfos : ListCart) {
						cart_id = cartInfos.getId();
					}
				}
				
				if(cart!=null){
					for (Cart c : cart){
					 ProductID = productImpl.getProduct(c.getP().getID()).getID();
					 quantity_product = c.getQuantity();
					 price_product = productImpl.getProduct(c.getP().getID()).getPrice()*c.getQuantity();
					 System.out.println("ProductID la "+ProductID);
					 System.out.println("Quantity la "+quantity_product);
					 productImpl.addCartDetail(new CartDetail(0, cart_id, ProductID, quantity_product, price_product));
				}}
				
				
				
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request,response);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
}
	
	public String dateTime(){
		String dateTime ="";
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int day = c.get(Calendar.DAY_OF_MONTH)+3;
		dateTime = day+"/"+month+"/"+year;
		return dateTime;
	}

}
