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
	User user = (User) session.getAttribute("user");
	if (user != null) {
	%>
	<form action="edit" method="post">
		<input type="hidden" name="id" value="<%=user.getId()%>">Name<input
			type="text" name="nm" value="<%=user.getName()%>"><br>
		Email<input type="email" name="em" value="<%=user.getEmail()%>"><br>
		Age<input type="number" name="age" value="<%=user.getAge()%>"><br>
		Gender<input type="radio" name="gender" value="male">Male <input
			type="radio" name="gender" value="female">Female<br>
		Phone Number<input type="tel" name="ph" value="<%=user.getPhone()%>"><br>
		Password<input type="password" name="ps" value="<%=user.getPassword()%>"><br> 
			<input type="submit" value="Login">
	</form>
	<%
	} else {
	response.sendRedirect("login.jsp");

	}
	%>

</body>
</html>