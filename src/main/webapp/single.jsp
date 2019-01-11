<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<%@page import="com.haipham.connection.AccountImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.haipham.connection.ProductImpl"%>
<%@page import="com.haipham.connection.CmtImpl"%>
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
<%@page import="com.haipham.model.CommentModel"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.haipham.model.Cart"%>
<%@page import="java.util.List"%>
<%@page import="com.haipham.connection.ProductImpl"%>
<%@page import="com.haipham.connection.CmtImpl"%>

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
int product_id = Integer.parseInt(request.getParameter("product_id"));

ProductImpl add = new ProductImpl();

CmtImpl cmt = new CmtImpl();
List<CommentModel> clist = new ArrayList<CommentModel>();
String pi = ""+product_id;
Product p = add.getsingleProduct(pi);
List<Product> list = new ArrayList<Product>();
String category = ""+p.getCategoryID(); 
list = add.getProductcat(category);
clist = cmt.getComment(product_id);
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
	  	      <div class="box_11"><a href="checkout.html">
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
	          <%
		String username="";
	       HttpSession sessionUser = request.getSession();
         if(sessionUser.getAttribute("username")!=null)
        	 username= (String) session.getAttribute("username");
     %>
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
		            <div class="clearfix"> </div>
			 </div>
		     <div class="clearfix"> </div>
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
									<li><a href="men.html">watches</a></li>
									<li><a href="men.html">Blazers</a></li>
									<li><a href="men.html">Suits</a></li>
									<li><a href="men.html">Trousers</a></li>
									<li><a href="men.html">Jeans</a></li>
									<li><a href="men.html">Shirts</a></li>
									<li><a href="men.html">Sweatshirts & Hoodies</a></li>
									<li><a href="men.html">Swim Wear</a></li>
									<li><a href="men.html">Accessories</a></li>
								</ul>	
							</div>							
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>Women</h4>
								<ul>
									<li><a href="men.html">Watches</a></li>
									<li><a href="men.html">Outerwear</a></li>
									<li><a href="men.html">Dresses</a></li>
									<li><a href="men.html">Handbags</a></li>
									<li><a href="men.html">Trousers</a></li>
									<li><a href="men.html">Jeans</a></li>
									<li><a href="men.html">T-Shirts</a></li>
									<li><a href="men.html">Shoes</a></li>
									<li><a href="men.html">Coats</a></li>
									<li><a href="men.html">Accessories</a></li>
								</ul>	
							</div>							
						</div>
						<div class="col2">
							<div class="h_nav">
								<h4>Trends</h4>
								<ul>
									<li class>
										<div class="p_left">

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
									<li><a href="men.html">watches</a></li>
									<li><a href="men.html">Blazers</a></li>
									<li><a href="men.html">Suits</a></li>
									<li><a href="men.html">Trousers</a></li>
									<li><a href="men.html">Jeans</a></li>
									<li><a href="men.html">Shirts</a></li>
									<li><a href="men.html">Sweatshirts & Hoodies</a></li>
									<li><a href="men.html">Swim Wear</a></li>
									<li><a href="men.html">Accessories</a></li>
								</ul>	
							</div>							
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>Women</h4>
								<ul>
									<li><a href="men.html">Watches</a></li>
									<li><a href="men.html">Outerwear</a></li>
									<li><a href="men.html">Dresses</a></li>
									<li><a href="men.html">Handbags</a></li>
									<li><a href="men.html">Trousers</a></li>
									<li><a href="men.html">Jeans</a></li>
									<li><a href="men.html">T-Shirts</a></li>
									<li><a href="men.html">Shoes</a></li>
									<li><a href="men.html">Coats</a></li>
									<li><a href="men.html">Accessories</a></li>
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
      <div class="col-md-9 single_top">
      	<div class="single_left">
      	  <div class="labout span_1_of_a1">
			<div>
					 <img src="images/<%=p.getImage()%>.jpg"/>
				  </div>
		          <div class="clearfix"></div>	
	    </div>
		<div class="cont1 span_2_of_a1 simpleCart_shelfItem">
				<h1><%=p.getName()%></h1>
				<p class="availability">Availability: <span class="color">In stock</span></p>
			    <div class="price_single">
				  <span class="reducedfrom"><%=p.getPrice()%>$</span>
				</div>
		
				
			    <a class="button item_add cbp-vm-icon cbp-vm-add" href="CartServlet?type=single&command=addCart&product_id=<%=p.getID()%>">Add to cart</a>
			</div>
		    <div class="clearfix"> </div>
		</div>
		</div>
		<div class="col-md-3 tabs">
	      <h3 class="m_1">Related Products</h3>
	       <%for(Product c:list){%> 
	       <a href=single.jsp?product_id=<%=c.getID()%> class="link-cart">
	      <ul class="product">
	      	<li class="product_img"><img src="images/<%=c.getImage() %>.jpg" class="img-responsive" alt=""/></li>
	      	<li class="product_desc">
	      		<h4><a href="single.jsp?product_id=<%=c.getID()%>"><%=c.getName() %></a></h4>
	      		<p class="single_price"><%=c.getPrice() %></p>
	      	    <a class="" href="CartServlet?command=addCart&product_id=<%=c.getID()%>">Add to cart</a>
	        </li>
	      	<div class="clearfix"> </div>
	      </ul>
	      </a>
	      <%} %>
   </div>
  <div class="footer">
   	 <div class="container">
   	 	<div class="newsletter">
   	 	<%
   	 	AccountImpl accountImpl = new AccountImpl();
   	 	
	       
         if(sessionUser.getAttribute("username")!=null){ //co gia tri
        	 username= (String) session.getAttribute("username");
        	  role = accountImpl.getRole(username);
     %>
			<form method="post" action="CommentServlet?ID=<%=product_id%>">	
			<textarea placeholder="Write your review..." rows="10" cols="80" id ="cmt" name ="cmt" ></textarea>
			<input type="submit" name="submit" value="Comment">
			</form><%} %>
		<div id="review">Customer's Reviews :</div>
		<%for(CommentModel com:clist){%> 
		<form method="post" action="CommentServlet?&idcmt=<%=com.getIdcmt()%>&ID=<%=product_id%>">
		<div id="cmt">
		<p id="cmt_date">Date: <%=com.getDate() %></p>
		
		<%if((sessionUser.getAttribute("username")!=null) && (role.equals("staff"))){ %>
			<input type="image" src="images/delete.jpg" name="submit"value="delete" style="float:right">
		<!-- 	<img  src="images/delete.jpg" id="delete_cmt" style="float:right"/> -->
		<%} %>
		<div id="cmt_contain">
			<p>Comment: <%=com.getContent() %></p>
		</div>
		<p id="cmt_name">Review by: <b style="color:#3291BF"><%=com.getName() %></b></p>
		
		</div>
		</form>
		<% } %>
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
<!-- FlexSlider -->
<script defer src="js/jquery.flexslider.js"></script>
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
<script>
// Can also be used with $(document).ready()
$(window).load(function() {
  $('.flexslider').flexslider({
    animation: "slide",
    controlNav: "thumbnails"
  });
});
</script>
</body>
</html>		