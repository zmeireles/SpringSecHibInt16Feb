<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" media="screen"
	href="resources/css/style.css" />

<title>Role</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<c:url value="searchrole" var="searchRoleUrl" />
	<c:url value="createrole" var="createRoleUrl" />
	<c:url value="deleterole" var="deleteRoleUrl" />
	<form:form method="post">
		<h1 id="banner">Role</h1>
		<hr />

		<div class="role">
			<table>
			</br>
			</br>
				<tr>
					<td ><a  href="${searchRoleUrl}">Search Role</a></td>
				</tr>
				<tr>
					<td ><a href="${createRoleUrl}">Create Role</a></td>
				</tr>
				<tr>
					<td ><a href="${deleteRoleUrl}">Delete Role</a></td>
				</tr>
			</table>

		</div>
	</form:form>
</body>
</html>