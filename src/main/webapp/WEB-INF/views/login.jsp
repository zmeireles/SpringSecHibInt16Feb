<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- If there is Error returned from controller to Login pagin page need to be  displayed in red else there should not be any text -->

<core:if test="${not empty error}">
		<div>
			Your Login Attempt Failed , Try Again
			<br/>
			Due To  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
</core:if>



<%-- <form action="<core:url value="j_spring_security_check" name="loginForm" method="post"></core:url>"> --%>
<form action="<core:url  value="j_spring_security_check"/>"  name="loginForm" method="post">
<center>
	<table>
		<tr>
			<td>User</td>
			<td><input type="text" name="j_username" value=''></td>
		</tr>
		
		<tr>
			<td>User</td>
			<td><input type="password" name="j_password"></td>
		</tr>
		
		<tr>
			<td><input type="submit" name="Submit" value="Submit"></td>
		</tr>
		
		
	</table>

</center>
</form>
</body>
</html>