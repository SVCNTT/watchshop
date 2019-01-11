package com.haipham.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LogInFilter
 */
@WebFilter("/LogInFilter")
public class LogInFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LogInFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request; // chuyen tu kieu ServletRequest(cha) ve HTTPServlet(con)
		HttpServletResponse res = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		
		//1st : Lay ve requestURI
		String requestURI = req.getRequestURI();
		if( requestURI.endsWith("checkout.jsp") &&
				
				session.getAttribute("username")==null){   // Neu vao trang checkout.jsp hoac trang CartServlet thi se tu dong chuyen ve login.jsp
				
				
			res.sendRedirect("login.jsp");
		}else{											// Cac trang con lai duoc phep truy cap
			
		chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	
	

	   @Override
	   public void init(FilterConfig fConfig) throws ServletException {
	       System.out.println("LogFilter init!");
	   }
	 
	   

}
