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

<title>Delete Role</title>
<script type="text/javascript" src="http://jquery.bassistance.de/validate/lib/jquery.js"></script>
<script  type="text/javascript" src="http://jquery.bassistance.de/validate/jquery.validate.js"></script>
<script>
$().ready(function () {
        // 1. prepare the validation rules and messages.
        $("#roleDelete").validate({
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
#roleDelete label.error{
	color:red;	
}
#roleDelete input.error{
border:3px solid red;
}
</style>

</head>
<body>
	<form:form id ="roleDelete" method="POST" commandName="role" class="role-form">
		<fieldset>
			<legend> Delete Role</legend>
			<table>
				<tr>
					<td><form:label path="name">
							<spring:message code="label.name"></spring:message>

						</form:label></td>
					<td><form:input path="name"></form:input></td>
				</tr>
				<td><input type="submit" value="Delete"></td>
				<td><input type="button" onclick="history.back();" value="Back">
				</td>
			</table>

		</fieldset>

	</form:form>
</body>
</html>