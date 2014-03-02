<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" media="screen"
	href="resources/css/style.css" />
	

<title>Insert title here</title>
<script type="text/javascript" src="http://jquery.bassistance.de/validate/lib/jquery.js"></script>
<script  type="text/javascript" src="http://jquery.bassistance.de/validate/jquery.validate.js"></script>
<script>
$().ready(function () {
        // 1. prepare the validation rules and messages.
        $("#roleView").validate({
			rules: {
				"name": "required"
			},
			messages : {
				"name": "Requried"
			}
		});
 
        
        
    });
       
</script>
<style>
#roleView label.error{
	color:red;	
}
#roleView input.error{
border:3px solid red;
}
</style>
</head>
<body>
	<form:form id ="roleView" method="post" class="role-form" commandName="role">

		<fieldset>
			<legend>Role Search</legend>
			<table>
				<tr>
					<td><form:label path="name">
							<spring:message code="label.name" ></spring:message>
						</form:label></td>
					<td><form:input path="name" /></td>


				</tr>

				<tr>
					<td><input type="submit" value="Search" ></td>
					<td><input type="button" onclick="history.back();"
						value="Back"></td>
				</tr>
			</table>


		</fieldset>


		<core:if test="${!empty roleList}">
			<table border="1">
				<tr>

					<td>RoleID</td>
					<td>Role Name</td>
				</tr>
				<core:forEach items="${roleList}" var="role">
					<tr>
						<td>${role.id}</td>
						<td>${role.name}</td>
					</tr>
				</core:forEach>
			</table>
		</core:if>



	</form:form>
	<table align="center">
		<tr>
			<td><a href="createrole">Create New role</a>
			<td>
		</tr>
	</table>

</body>
</html>