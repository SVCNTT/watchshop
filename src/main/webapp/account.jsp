<%@page import="com.adminsite.entity.UserEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                    <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"> <%=session.getAttribute("username") %></span>
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
                                <!-- <li><a href="controller?action=orderDetail">Order Detail</a></li> -->
                            </ul>
                        </li>
                        
                       <!-- <li><a class="ajax-link" href="gallery.jsp"><i class="glyphicon glyphicon-picture"></i><span> Gallery</span></a> --> 
                        </li>                     
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
                <a href="#">User</a>
                
            </li>
            
        </ul>
        <a href="index.jsp">Back to home page</a>
    </div>
	
    <div class="row">
    <div class="box col-md-12">
    <div class="box-inner">
    <div class="box-header well" data-original-title="">
        <h2><i class=""></i>User</h2>
    </div>
    <div class="box-content">
    
    <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
    <a href="#" id="addUser-popup"><img src="img/add.png" alt="Add" style="width:30px;height:30px;"></a>
     
    <thead>
    <tr>
        <th>ID</th>
        <th>Username</th>
         <th>Fullname</th>
        <th>Email</th>
        <th>Role</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <%List<UserEntity> list =  (List<UserEntity>)request.getAttribute("UserList");
    	UserEntity user = new UserEntity();
    	for(int i = 0 ; i < list.size() ; i ++){
    		user = list.get(i);  
    %>
    <tr>
        <td><%=user.getId() %></td>
        <td class="center"><%=user.getUsername() %></td>
        <td class="center"><%=user.getFullname() %></td>
        <td class="center"><%=user.getEmail() %></td>
        <td class="center"><%=user.getRole() %></td>
        <td class="center">
            <a class="btn btn-info" href="#" id="editUser-popup" onclick="editUser(<%=user.getId()%>)">
                <i class="glyphicon glyphicon-edit icon-white"></i>
                Edit
            </a>
            <a class="btn btn-danger" href="DeleteUser?id=<%=user.getId() %>">
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
    
    
    <!-- PopUp Edit box -->
    <div id="edit-popup" class="animated bounceInDown">	
			<form action="EditUserServ" method="post" style="position: absolute;margin-left:5%;">
				<h2 style="text-align: -webkit-center;">Edit your account</h2>
				<table style="margin: 0 auto;" id="signup-table">
					<tr id="popup-tr">
						<td>Full name</td>
						<td><input type="hidden" name="idUser" id="idUser"><input type="text" name="fullname" id="fullname"></td>
						<td><img src="img/ok.png" id="okFname"></td>
					</tr>
					<tr>
						<td></td>
						<td class="check" id="checkFullname" style="display:none;">Require at least 6 characters</td>
					</tr>
					<tr id="popup-tr">
						<td>User name</td>
						<td><input type="text" readonly name="username" id="username"></td>
						<td><img src="img/ok.png" id="okUser"></td>
					</tr>
					<tr>
						<td></td>
						<td class="check" id="checkEmptyUser" style="display:none;">Empty is not allow</td>
						<td class="check" id="checkUsername" style="display:none;">User name is already in use</td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password" id="password"></td>
						<td><img src="img/ok.png" id="okPass"></td>
				    </tr>
				    <tr>
						<td></td>
						<td class="check" id="checkPassword" style="display:none;">Require at least 6 characters</td>
					</tr>
				    <tr id="popup-tr">
						<td>Email</td>
						<td><input readonly type="text" name="email" id="email"></td>
						<td><img src="img/ok.png" id="okEmail"></td>
				    </tr>
				     <tr>
						<td></td>
						<td class="check" id="checkEmptyEmail" style="display:none;">Empty is not allow</td>
						<td class="check" id="checkEmail" style="display:none;">Email is already in use</td>
					</tr>
					<tr id="popup-tr">
						<td>Role</td>
						<td><select id="role" name="role">
						  <option value="staff">Staff</option>
						  <option value="customer">Customer</option>
						</select></td>
				    </tr>
				
				 <tr id="popup-tr" class="submit">
				 	
				 	<td><input id="signupEdit-btn" type="submit" value="Update"></td>
				 	<td><a href="#" id="cancelEdit-btn">Cancel</a></td>
				 </tr>
				</table>
			</form>
		</div>
	<!-- End PopUp Edit box -->
    
    
    
   
    
    <!-- PopUp Sign up box -->
    <div id="user-popup" class="animated bounceInDown">
    	
			<form action="AddUserServ" method="post" style="position: absolute;margin-left:5%;">
				<h2 style="text-align: -webkit-center;">Create your account</h2>
				<table style="margin: 0 auto;" id="signup-table">
					<tr id="popup-tr">
						<td>Full name</td>
						<td><input type="text" name="fullname" id="fullname2"></td>
						<td><img src="img/ok.png" id="okFname2"></td>
					</tr>
					<tr>
						<td></td>
						<td class="check" id="checkFullname2" style="display:none;">Require at least 6 characters</td>
					</tr>
					<tr id="popup-tr">
						<td>User name</td>
						<td><input type="text" name="username" id="username2"></td>
						<td><img src="img/ok.png" id="okUser2"></td>
					</tr>
					<tr>
						<td></td>
						<td class="check" id="checkEmptyUser2" style="display:none;">Empty is not allow</td>
						<td class="check" id="checkUsername2" style="display:none;">User name is already in use</td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password" id="password2"></td>
						<td><img src="img/ok.png" id="okPass2"></td>
				    </tr>
				    <tr>
						<td></td>
						<td class="check" id="checkPassword2" style="display:none;">Require at least 6 characters</td>
					</tr>
				    <tr id="popup-tr">
						<td>Email</td>
						<td><input type="text" name="email" id="email2"></td>
						<td><img src="img/ok.png" id="okEmail2"></td>
				    </tr>
				     <tr>
						<td></td>
						<td class="check" id="checkEmptyEmail2" style="display:none;">Empty is not allow</td>
						<td class="check" id="checkEmail2" style="display:none;">Email is already in use</td>
					</tr>
					<tr id="popup-tr">
						<td>Role</td>
						<td><select id="role2" name="role">
						  <option value="staff">Staff</option>
						  <option value="customer">Customer</option>
						</select></td>
				    </tr>
				
				 <tr id="popup-tr" class="submit">
				 	
				 	<td><input id="signup-btn" type="submit" value="Sign Up"></td>
				 	<td><a href="#" id="cancel-btn">Cancel</a></td>
				 </tr>
				</table>
			</form>
		</div>
	<!-- End PopUp Sign up box -->
	
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
