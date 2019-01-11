<%@page import="com.adminsite.entity.CategoryEntity"%>
<%@page import="com.adminsite.dao.CategoryDao"%>
<%@page import="com.adminsite.entity.ProductEntity"%>
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

    <!-- jQuery -->
    <script src="bower_components/jquery/jquery.min.js"></script>
    <script src="js/popup.js" type="text/javascript"></script>
    <script src="js/editUser_ajax.js" type="text/javascript"></script>
    <script src="js/addUser_ajax.js" type="text/javascript"></script>
    <script src="js/jquery-ui.js" type="text/javascript"></script> 
	<script src="js/addProduct_ajax.js" type="text/javascript"></script>
	<script src="js/editProduct_ajax.js" type="text/javascript"></script>
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
                    <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"><%=session.getAttribute("username") %></span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">Profile</a></li>
                    <li class="divider"></li>
                    <li><a href="login.jsp">Logout</a></li>
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
                <a href="#">Product</a>
            </li>
        </ul>
    </div>

    <div class="row">
    <div class="box col-md-12">
    <div class="box-inner">
    <div class="box-header well" data-original-title="">
        <h2><i class=""></i>Product</h2>
    </div>
    <div class="box-content">
    <a  id="addProduct-popup" href="#"><img src="img/add.png" alt="Add" style="width:30px;height:30px;"></a>
    <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
    <thead>
    
    <tr>
    	
        <th>ID</th>
        <th>Name</th>
        <th>Category</th>
        <th>Price</th>
        <th>Image</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <%List<ProductEntity> productList = (List<ProductEntity>)request.getAttribute("ProductList"); 
    	for(int i = 0 ; i < productList.size() ; i++ ){
    		ProductEntity p = productList.get(i);
    %>
    <tr>
        <td><%=p.getId() %></td>
        <td class="center"><%=p.getName() %></td>
        <% CategoryDao dao = new CategoryDao();
        	List<CategoryEntity> list = dao.LoadSingleCate(p.getCategoryID());
        	String cate_name = list.get(0).getType();
        %>
        <td class="center"><%=cate_name %></td>
        <td class="center">
            <span class="label-success label label-default"><%=p.getPrice() %>$</span>
        </td>
        <td class="center"><img src="images/<%=p.getImage()%>.jpg" width="120" height="120"></td>
        
        <td class="center">
            <a class="btn btn-info" href="#" onclick="editProduct(<%=p.getId()%>)">
                <i class="glyphicon glyphicon-edit icon-white" ></i>
                Edit
            </a>
            <a class="btn btn-danger" href="deleteProduct?id=<%=p.getId()%>">
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
	
	
	
	
	
	
	<!-- Popup Product box -->
	<div id="product-popup" class="animated bounceInDown">
    	
			<form action="addProductServ" method="post" style="position: absolute;margin-left:5%;" enctype="multipart/form-data">
				<h2 style="text-align: -webkit-center;">Add new product</h2>
				<table style="margin: 0 auto;" id="signup-table">
					<tr id="popup-tr">
						<td>Product Name</td>
						<td><input type="text" name="productName" id="productName"></td>
						<td><img src="img/ok.png" id="okproductName"></td>
					</tr>
					<tr>
						<td></td>
						<td class="check" id="checkproductName" style="display:none;">Empty is not allow</td>
					</tr>
					<tr id="popup-tr">
						<td>Category</td>
						<td><select id="productCate" name="productCate" id="productCate">
							<% List <CategoryEntity> cateList = (List<CategoryEntity>)request.getAttribute("CateList");
							for(int i = 0 ; i < cateList.size() ; i++ ){
					    		CategoryEntity c = cateList.get(i); 
					    	%>
							 	<option value="<%=c.getId()%>"><%=c.getType() %></option>
							<%	} %>
							</select>
						</td>
					</tr>
					<tr>
						<td>Price</td>
						<td><input type="text" name="productPrice" id="productPrice"></td>
						<td><img src="img/ok.png" id="okproductPrice"></td>
				    </tr>
				    <tr>
						<td></td>
						<td class="check" id="checkproductType" style="display:none;">Empty is not allow</td>
					</tr>
				    <tr id="popup-tr">
						<td>Image</td>
						<td><input type="file" id="productImg" name="productImg"></td>
				    </tr>
				 <tr id="popup-tr">
				 	
				 	<td><input id="addproduct-btn" type="submit" value="Add"></td>
				 	<td><a href="#" id="cancelproduct-btn">Cancel</a></td>
				 </tr>
				</table>
			</form>
		</div>
	<!-- End Popup Product box -->
	
	
	
	<!-- Popup Edit Product box -->
	<div id="Editproduct-popup" class="animated bounceInDown">
    	
			<form action="editProductServ" method="post" style="position: absolute;margin-left:5%;" enctype="multipart/form-data">
				<h2 style="text-align: -webkit-center;">Edit your product</h2>
				<table id="edit_table" style="margin: 0 auto;">
					<tr id="popup-tr">
						<td>Product Name</td>
						<td><input type="hidden" name="idProduct" id="idProduct"><input type="text" name="productName" id="productName2"></td>
						<td><img src="img/ok.png" id="okproductName2"></td>
					</tr>
					<tr>
						<td></td>
						<td class="check" id="checkproductName2" style="display:none;">Empty is not allow</td>
					</tr>
					<tr id="popup-tr">
						<td>Category</td>
						<td><select id="productCate" name="productCate" id="productCate2">
							<% List <CategoryEntity> cateList2 = (List<CategoryEntity>)request.getAttribute("CateList");
							for(int i = 0 ; i < cateList2.size() ; i++ ){
					    		CategoryEntity c2 = cateList2.get(i); 
					    	%>
							 	<option value="<%=c2.getId()%>"><%=c2.getType() %></option>
							<%	} %>
							</select>
						</td>
					</tr>
					<tr>
						<td>Price</td>
						<td><input type="text" name="productPrice" id="productPrice2"></td>
						<td><img src="img/ok.png" id="okproductPrice2"></td>
				    </tr>
				    <tr>
						<td></td>
						<td class="check" id="checkproductType2" style="display:none;">Empty is not allow</td>
					</tr>
				    <tr id="popup-tr">
						<td>Image</td>
						<td><input type="text" id="productImg3"/></td>
						<!-- <td><input type="file" id="productImg2" name="productImg" data-input="false" data-buttonText="Browse"></td> -->
				    </tr>
				    <tr id="popup-tr">
				    	<td></td>
				    	<td><input type="file" id="productImg2" name="productImg" data-input="false" data-buttonText="Browse"></td>
				    </tr>
				 	<tr id="popup-tr">
				 	
					 	<td><input id="editproduct-btn" type="submit" value="Update"></td>
					 	<td><a href="#" id="cancelEditproduct-btn">Cancel</a></td>
				 	</tr>
				</table>
			</form>
		</div>
	<!-- End Edit Popup Product box -->

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
