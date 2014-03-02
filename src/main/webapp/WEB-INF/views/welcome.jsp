<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
		<table align="right">
			<tr>
				<td>
					<a href="<c:url value="j_spring_security_logout"/>">logout</a>  
				</td>
			</tr>
		</table>
	

	<center>
		<table>
			<tr>
				<td>${msg1}</td>
			</tr>

			<tr>
				<td>${msg2}</td>
			</tr>
			
			<tr>
				<td>${msg3}</td>
			</tr>
		
		
			
			
		</table>
	</center>
</body>
</html>

