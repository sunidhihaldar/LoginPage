<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogoutPage</title>
</head>
<body>
	<%
		String name = request.getParameter("username");
		out.print("<br><br><br>Do you want to logout " + name + " ?");
	%>
	<form action="logout" method="get">
		<input type="submit" value="Logout">
	</form>
</body>
</html>