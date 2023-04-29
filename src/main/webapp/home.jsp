<%@page import="org.jsp.userproduct.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <%
     User u=(User)session.getAttribute("user");
     if(u !=null) {
    	 %>
     
     
   
   <h2>
      welcome mr.<%=u.getName() %> 
   </h2>
   <h3>
       <a href="editUser.jsp">Edit your Profile</a>
   </h3>
    <h3>
       <a href="viewUser.jsp">view your Profile</a>
   </h3>
    <h3>
       <a href="delete">delete your Profile</a>
   </h3>
   <h3>
       <a href="logout">Logout</a>
   </h3>
   <h3>
		<a href="addProduct.jsp">Add product</a>
	</h3>
	<h3>
		<a href="viewproducts"> View products </a>
	</h3>
   <%
   }
   else{
   response.sendRedirect("login.jsp");
   }
   %>
</body>
</html>