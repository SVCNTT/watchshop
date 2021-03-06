<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<%@page import="org.apache.catalina.manager.util.SessionUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.haipham.connection.ProductImpl"%>
<%@page import="com.haipham.model.Cart"%>
<%@page import="com.haipham.model.Category"%>


<html>
<head>
<title>Watches an E-Commerce online Shopping Category Flat Bootstrap Responsive Website Template| Men :: w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Watches Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/component.css" rel='stylesheet' type='text/css' />
<%@page import="com.haipham.model.Product"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.haipham.connection.ProductImpl"%>
<!-- Custom Theme files -->
<!--webfont-->
<link href='//fonts.googleapis.com/css?family=PT+Sans+Narrow:400,700' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Dorsa' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="js/jquery.easydropdown.js"></script>
<script src="js/simpleCart.min.js"> </script>
</head>
<body>
<%
ProductImpl add = new ProductImpl();
List<Product> list = new ArrayList<Product>();
list = add.getList();
String product_id ="";
if(request.getParameter("product_id")!=null){
    	product_id = request.getParameter("product_id");
    }
	
%>
<%
	 ProductImpl productImpl = new ProductImpl();
	ArrayList<Cart> cart = (ArrayList<Cart>) session.getAttribute("cart");
	double total = 0;	
	int count = 0;
%>
	<div class="men_banner">
   	  <div class="container">
   	  	<div class="header_top">
   	  	   <div class="header_top_left">
	  	      <div class="box_11"><a href="checkout.jsp">
		      <h4>
		      
	<%
										if (cart != null) {
											for (Cart c : cart) {
												int ms = c.getP().getID();
												 count = c.getQuantity();
												total = total + (c.getQuantity() * productImpl.getProduct(c.getP().getID()).getPrice());
									%><%}} %>
		      	<p>Cart: <span><%=total%> $</span> <!-- (<span id="simpleCart_quantity" class="simpleCart_quantity"></span> items) --></p>
		      	<img src="images/bag.png" alt=""/>
		      	<div class="clearfix"> </div>
		      </h4>
		      </a></div>
	          <p class="empty"><a href="javascript:;" class="simpleCart_empty">Empty Cart</a></p>
	          <div class="clearfix"> </div>
	       </div>
	  <div class="header_top_right">
		  	 <div class="lang_list">
				<select tabindex="4" class="dropdown">
					<option value="" class="label" value="">$ Us</option>
					<option value="1">Dollar</option>
					<option value="2">Euro</option>
				</select>
			 </div>
			 
			 <ul class="header_user_info">
				 
				<%
		String username="";
		String role="";
         if(session.getAttribute("username")!=null){ 
        	 username= (String) session.getAttribute("username");
        	 	role = (String)session.getAttribute("role");
		  		if (!role.equals("customer")){
     %>
				<li class="user_desc">Hello <%=username %></li><br>	
			  
			  	<a class="login" href="LogOutServlet?command=logout">

					<li class="user_desc">Logout
						<a href="UserServ" id="linkadmin">Admin site</a>
					</li>
			     </a>
			     
			  <%}
		  		
		  	}
         	else{ %>
				   <a class="login" href="login.jsp">
					<i class="user"> </i> 
					<li class="user_desc">Login</li>
				  </a><%} %>
				  
				 

		     </ul>
		    
		    <!-- start search-->
				<div class="search-box">
				   <div id="sb-search" class="sb-search">
					  <form method="post" action="SearchServlet">
						 <input class="sb-search-input" placeholder="Enter your search term..." type="search" name="search" id="search">
						 <input class="sb-search-submit" type="submit" value="">
						 <span class="sb-icon-search"> </span>
					  </form>
				    </div>
				 </div>
				 <!----search-scripts---->
				 <script src="js/classie1.js"></script>
				 <script src="js/uisearch.js"></script>
				   <script>
					 new UISearch( document.getElementById( 'sb-search' ) );
				   </script>
					<!----//search-scripts---->
			 </div>
	    </div>
   	  <div class="header_bottom">
	   <div class="logo">
		  <h1><a href="index.jsp"><span class="m_1">W</span>atches</a></h1>
	   </div>
	   <div class="menu">
	     <ul class="megamenu skyblue">
			<li class="active grid"><a class="color2" href="#">Mens</a>
				<div class="megapanel">
					<div class="row">
						<div class="col1">
							<div class="h_nav">
								<h4>Men</h4>
								<ul>
									<li><a href="men.html">Watches</a></li>
									
									
								</ul>	
							</div>							
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>Women</h4>
								<ul>
									<li><a href="men.html">Watches</a></li>
									
								</ul>	
							</div>							
						</div>
						<div class="col2">
							<div class="h_nav">
								<h4>Trends</h4>
								<ul>
									<li class>
										<div class="p_left">
										  <img src="images/p1.jpg" class="img-responsive" alt=""/>
										</div>
										<div class="p_right">
											<h4><a href="#">Denim shirt</a></h4>
											<span class="item-cat"><small><a href="#">watches</a></small></span>
											<span class="price">29.99 $</span>
										</div>
										<div class="clearfix"> </div>
									</li>
									<li>
										<div class="p_left">
										  <img src="images/p2.jpg" class="img-responsive" alt=""/>
										</div>
										<div class="p_right">
											<h4><a href="#">Denim shirt</a></h4>
											<span class="item-cat"><small><a href="#">watches</a></small></span>
											<span class="price">29.99 $</span>
										</div>
										<div class="clearfix"> </div>
									</li>
									<li>
										<div class="p_left">
										  <img src="images/p3.jpg" class="img-responsive" alt=""/>
										</div>
										<div class="p_right">
											<h4><a href="#">Denim shirt</a></h4>
											<span class="item-cat"><small><a href="#">watches</a></small></span>
											<span class="price">29.99 $</span>
										</div>
										<div class="clearfix"> </div>
									</li>
								</ul>	
							</div>												
						</div>
					  </div>
					</div>
			</li>
			<li><a class="color4" href="#">womens</a>
				<div class="megapanel">
					<div class="row">
						<div class="col1">
							<div class="h_nav">
								<h4>Men</h4>
								<ul>
									<li><a href="men.html">Watches</a></li>
									
								</ul>	
							</div>							
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>Women</h4>
								<ul>
									<li><a href="men.html">Watches</a></li>
									
								</ul>	
							</div>							
						</div>
						<div class="col2">
							<div class="h_nav">
								<h4>Trends</h4>
								<ul>
									<li class>
										<div class="p_left">
										  <img src="images/p1.jpg" class="img-responsive" alt=""/>
										</div>
										<div class="p_right">
											<h4><a href="#">Denim shirt</a></h4>
											<span class="item-cat"><small><a href="#">watches</a></small></span>
											<span class="price">29.99 $</span>
										</div>
										<div class="clearfix"> </div>
									</li>
									<li>
										<div class="p_left">
										  <img src="images/p2.jpg" class="img-responsive" alt=""/>
										</div>
										<div class="p_right">
											<h4><a href="#">Denim shirt</a></h4>
											<span class="item-cat"><small><a href="#">watches</a></small></span>
											<span class="price">29.99 $</span>
										</div>
										<div class="clearfix"> </div>
									</li>
									<li>
										<div class="p_left">
										  <img src="images/p3.jpg" class="img-responsive" alt=""/>
										</div>
										<div class="p_right">
											<h4><a href="#">Denim shirt</a></h4>
											<span class="item-cat"><small><a href="#">watches</a></small></span>
											<span class="price">29.99 $</span>
										</div>
										<div class="clearfix"> </div>
									</li>
								</ul>	
							</div>												
						</div>
					  </div>
					</div>
				</li>				
				<li><a class="color10" href="brands.html">Brands</a></li>
				<li><a class="color3" href="index.jsp">Sale</a></li>
				<li><a class="color7" href="404.html">News</a></li>
				<div class="clearfix"> </div>
			</ul>
			</div>
	        <div class="clearfix"> </div>
	    </div>
	  </div>
   </div>
   <div class="men">
    <div class="container">
    	<div class="col-md-4 sidebar_men">
    	  <h3>Categories</h3>
    	  <ul class="product-categories color">
    	  <%
    	  		ProductImpl cate = new ProductImpl();
    	  		List<Category> cate_list = new ArrayList<Category>();
    	  		cate_list = cate.getCategoryType();
    	  		for(int i = 0 ; i < cate_list.size() ; i ++){
    	  %>
    	  	<li class="cat-item cat-item-42"><a href="search2.jsp?category=<%=cate_list.get(i).getID() %> "><%=cate_list.get(i).getType() %></a>
    	  <% } %> 
			
			
		 </ul>
		 
		</div>
    	<div class="col-md-8 mens_right">
    		<div class="dreamcrub">
			   	<ul class="breadcrumbs">
                    <li class="home">
                       <a href="index.jsp" title="Go to Home Page">Home</a>&nbsp;
                       <span>&gt;</span>
                    </li>
                    <li class="home">&nbsp;
                        Men / Women&nbsp;
                    </li>
                </ul>
                <ul class="previous">
                	<li><a href="index.jsp">Back to Previous Page</a></li>
                </ul>
                <div class="clearfix"></div>
			   </div>
			   <div class="mens-toolbar">
                 <div class="sort">
               	   <div class="sort-by">
		            <label>Sort By</label>
		            <select>
		                            <option value="">
		                    Position                </option>
		                            <option value="">
		                    Name                </option>
		                            <option value="">
		                    Price                </option>
		            </select>
		            <a href=""><img src="images/arrow2.gif" alt="" class="v-middle"></a>
                   </div>
    		     </div>
    	        <ul class="women_pagenation dc_paginationA dc_paginationA06">
			     <li><a href="#" class="previous">Page : </a></li>
			     <li class="active"><a href="#">1</a></li>
			     <li><a href="#">2</a></li>
		  	    </ul>
                <div class="clearfix"></div>		
		        </div>
    		<div id="cbp-vm" class="cbp-vm-switcher cbp-vm-view-grid">
					<div class="cbp-vm-options">
						<a href="#" class="cbp-vm-icon cbp-vm-grid cbp-vm-selected" data-view="cbp-vm-view-grid" title="grid">Grid View</a>
						<a href="#" class="cbp-vm-icon cbp-vm-list" data-view="cbp-vm-view-list" title="list">List View</a>
					</div>
					<div class="pages">   
        	 <div class="limiter visible-desktop">
               <label>Show</label>
                  <select>
                            <option value="" selected="selected">
                    9                </option>
                            <option value="">
                    15                </option>
                            <option value="">
                    30                </option>
                  </select> per page        
               </div>
       	   </div>
       	   
					<div class="clearfix"></div>
						<ul>
						 <%
            				for (Product p : list ){
            					
           				 %> 
					  <li class="simpleCart_shelfItem">
							<a class="cbp-vm-image" href=single.jsp?product_id=<%=p.getID()%>>
							 <div class="view view-first">
					   		  <div class="inner_content clearfix">
								<div class="product_image">
								
									<div class="mask1"><img src="images/<%=p.getImage()%>.jpg" alt="image" class="img-responsive zoom-img"></div>
									<div class="mask">
			                       		<div class="info">Quick View</div>
					                 </div>
					                 <div class="product_container">
									   <h4><%=p.getName()%></h4>
									
									   <div class="price mount item_price"><%=p.getPrice() %>$</div>
									   <a class="button item_add cbp-vm-icon cbp-vm-add" href="CartServlet?type=men&command=addCart&product_id=<%=p.getID()%>">Add to cart</a>
									 </div>		
								  </div>
			                     </div>
		                      </div>
		                    </a>
						</li><%} %>
					</ul>
				</div>
				<%-- <%} %> --%>
				<script src="js/cbpViewModeSwitch.js" type="text/javascript"></script>
                <script src="js/classie.js" type="text/javascript"></script>
    	</div>
    </div>
   </div>
   <div class="footer">
   	 <div class="container">
   		<div class="cssmenu">
		   <ul>
			<li class="active"><a href="#">Privacy</a></li>
			<li><a href="#">Terms</a></li>
			<li><a href="#">Shop</a></li>
			<li><a href="#">About</a></li>
			<li><a href="contact.html">Contact</a></li>
		  </ul>
		</div>
		<ul class="social">
			<li><a href=""> <i class="instagram"> </i> </a></li>
			<li><a href=""><i class="fb"> </i> </a></li>
			<li><a href=""><i class="tw"> </i> </a></li>
	    </ul>
	    <div class="clearfix"></div>
	    <div class="copy">
           <p> &copy; 2015 Watches. All Rights Reserved | Design by <a href="http://w3layouts.com/" target="_blank">W3layouts</a></p>
	    </div>
   	</div>
   </div>
</body>
</html>		