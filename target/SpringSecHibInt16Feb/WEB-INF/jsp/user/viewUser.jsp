<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<center>
		<core:if test="${!empty userList}">
			<table border="1">
				
				<core:forEach items="${userList}" var="user">
				<tr>
					<td>${user.userId}</td>
					<td>${user.userName}</td>					
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.address}</td>
				</tr>
				</core:forEach>
				
				<tr>
					<td>
						<a href="userRegistration">Create New user</a>
					</td>
				</tr>
				
			</table>
			</core:if>
		</center>



</body>
</html>