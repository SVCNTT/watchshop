<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
    <%
    	if(session.getAttribute("user") == null){
    		response.sendRedirect("login_admin.jsp");
    	}else{
    		response.sendRedirect(request.getContextPath()+"/UserServ"); 
    	}
    	
    %>
</body>
</html>
