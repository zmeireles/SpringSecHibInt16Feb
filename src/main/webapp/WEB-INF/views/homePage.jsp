<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<td>
				<a href='<core:url value="/j_spring_security_logout"/>'>Log Out</a>
			</td>
		</tr>
		<tr>
			<td>
				WelCome Message
			</td>
		</tr>
		<tr>
			<td>
				${msg1} 
			</td>
		</tr>
		
		
		<tr>
			<td>
				<a href="userRegistration" >User Registration </a>
				
				
			</td>
		</tr>
		
		
	</table>



</body>
</html>
