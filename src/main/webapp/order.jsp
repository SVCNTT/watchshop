<%@page import="com.adminsite.entity.OrderEntity"%>
<%@page import="com.adminsite.entity.UserEntity"%>
<%@page import="com.adminsite.dao.UserDao"%>
<%@page import="com.adminsite.dao.OrderDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Admin Site</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    

    <!-- The styles -->
    <link id="bs-css" href="css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="css/charisma-app.css" rel="stylesheet">
    
    <link href='bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
    <link href='css/jquery.noty.css' rel='stylesheet'>
    <link href='css/noty_theme_default.css' rel='stylesheet'>
    <link href='css/elfinder.min.css' rel='stylesheet'>
    <link href='css/elfinder.theme.css' rel='stylesheet'>
    <link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='css/uploadify.css' rel='stylesheet'>
    <link href='css/animate.min.css' rel='stylesheet'>	
	<link href="css/mycss.css" rel="stylesheet">
	<link href="css/animate.css" rel="stylesheet">
	
    <!-- jQuery -->
    <script src="bower_components/jquery/jquery.min.js"></script>
    <script src="js/popup.js" type="text/javascript"></script>
    <script src="js/editUser_ajax.js" type="text/javascript"></script>
    <script src="js/addUser_ajax.js" type="text/javascript"></script>
    <script src="js/jquery-ui.js" type="text/javascript"></script> 
    <!-- The fav icon -->
    <link rel="shortcut icon" href="img/favicon.ico">

</head>

<body>
    <!-- topbar starts -->
    <div class="navbar navbar-default" role="navigation">

        <div class="navbar-inner">
            <button type="button" class="navbar-toggle pull-left animated flip">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            

            <!-- user dropdown starts -->
            <div class="btn-group pull-right">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"><%=session.getAttribute("user") %></span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    
                    <li><a href="LogOut">Logout</a></li>
                </ul>
            </div>
          
        </div>
    </div>
    <!-- topbar ends -->
<div class="ch-container">
    <div class="row">
        
        <!-- left menu starts -->
        <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                    <div class="nav-sm nav nav-stacked">

                    </div>
                    <ul class="nav nav-pills nav-stacked main-menu">
                        <li class="nav-header">Main</li>
                        
                         <li class="accordion">
                            <a href="#"><i class="glyphicon glyphicon-plus"></i><span>Table</span></a>
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="controller?action=account">User</a></li>
                                <li><a href="controller?action=product">Product</a></li>
                                <li><a href="controller?action=category">Category</a></li>
                                <li><a href="controller?action=order">Order</a></li>
                            </ul>
                        </li>
                        
                        <!-- <li><a class="ajax-link" href="gallery.jsp"><i class="glyphicon glyphicon-picture"></i><span> Gallery</span></a> -->                  
                        <li><a href="error.jsp"><i class="glyphicon glyphicon-ban-circle"></i><span> Error Page</span></a>
                        </li>
                        <li><a href="login.jsp"><i class="glyphicon glyphicon-lock"></i><span> Login Page</span></a>
                        </li>
                    </ul>
                    
                </div>	
            </div>
        </div>
        <!--/span-->
        <!-- left menu ends -->

        

        <div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
                <div>
        <ul class="breadcrumb">
            <li>
                <a href="#">Home</a>
            </li>
            <li>
                <a href="#">Order</a>
            </li>
        </ul>
    </div>

    <div class="row">
    <div class="box col-md-12">
    <div class="box-inner">
    <div class="box-header well" data-original-title="">
        <h2><i class=""></i>Order</h2>
    </div>
    <div class="box-content">
    
    <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
    <thead>
    
    <tr>
    	
        <th>Id</th>
        <th>Customer</th>
        <th>Total price</th>
        <th>Address</th>
        <th>Date Delevery</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    
    <%
    	UserDao user_dao = new UserDao();    
    	List<OrderEntity> list = (List<OrderEntity>)request.getAttribute("OrderList");
    	OrderEntity o = new OrderEntity();
    	for(int i = 0 ; i < list.size() ; i ++){
    		 o = list.get(i);
    %>
    <tr>
        <td><%=o.getId() %></td>
        <%
        	int customer_id = o.getId_customer();
        	List<UserEntity> user_list = user_dao.LoadAccount(customer_id);
        	
        %>
        <td class="center"><%=user_list.get(0).getFullname() %></td>
        <td class="center">
        	<span class="label-success label label-default"><%=o.getTotal_price() %>$</span>
        </td>
        <td class="center"><%=o.getAddress() %></td>
        <td class="center"><%=o.getDate() %></td>
        <td class="center">
        <%
        	OrderDao order_dao = new OrderDao();
        	int status = order_dao.LoadSingleOrder(o.getId()).getStatus();
        	if(status == 1){
        %>
        	<span class="label-success label label-default" id="active">Active</span>
        <% }else{ %>
        	<span class="label-success label label-default" id="inactive">Inactive</span>
        <% } %>
        </td>
        <td class="center">
        	<a class="btn btn-info" href="OrderDetailServ?id=<%=o.getId()%>">
                <i class="glyphicon glyphicon-edit icon-white"></i>
                View
            </a>
            <a class="btn btn-success" href="editOrderStatus?id=<%=o.getId() %>" id="active-btn">
                <i class="glyphicon icon-white"></i>
                Active
            </a>
            <a class="btn btn-danger" href="deleteOrder?id=<%=o.getId() %>">
                <i class="glyphicon glyphicon-trash icon-white"></i>
                Delete
            </a>
        </td>
    </tr>
    <% } %>
    
        
    </tbody>
    </table>
    </div>
    </div>
    </div>
   

    <!-- content ends -->
    </div><!--/#content.col-md-0-->
</div><!--/fluid-row-->

    
    <hr>

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">

        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">Ã</button>
                    <h3>Settings</h3>
                </div>
                <div class="modal-body">
                    <p>Here settings can be configured...</p>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn btn-default" data-dismiss="modal">Close</a>
                    <a href="#" class="btn btn-primary" data-dismiss="modal">Save changes</a>
                </div>
            </div>
        </div>
    </div>
	
	

    <footer class="row">
		 <p class="col-md-9 col-sm-9 col-xs-12 copyright">&copy; <a href="http://usman.it" target="_blank">
                </a> 2016</p>
        <p class="col-md-3 col-sm-3 col-xs-12 powered-by">Developed by: <a
                href="#">L.T.B</a></p>
    </footer>

</div><!--/.fluid-container-->

<!-- external javascript -->

<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='bower_components/moment/min/moment.min.js'></script>
<script src='bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='js/jquery.dataTables.min.js'></script>

<!-- select or dropdown enhancer -->
<script src="bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rating plugin -->
<script src="js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="js/charisma.js"></script>


</body>
</html>
