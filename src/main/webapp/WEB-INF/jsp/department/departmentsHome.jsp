<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" media="screen"
	href="resources/css/style.css" />
<title>User</title>
</head>

<body>
	<jsp:include page="../menu.jsp" />

	<center>
		<core:if test="${!empty depList}">
			<table border="1">

				<core:forEach items="${depList}" var="dep">
					<tr>
						<td>${dep.name}</td>
						<td><a href="editDepartment?id=${dep.id}">Edit</a></td>
						<td><a href="deleteDepartment?id=${dep.id}">Delete</a></td>
					</tr>
				</core:forEach>

				<tr>
					<td colspan="3"><a href="createDepartment">Create New Department</a></td>
				</tr>

			</table>
		</core:if>
	</center>
</body>
</html>