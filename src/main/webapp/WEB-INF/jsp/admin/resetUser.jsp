<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form method="post" action="resetUser" commandName="user">
		<fieldset><legend>Reset Password  </legend> 
			<table>
					<tr>
						<td>
							<form:label path="userName">
								<spring:message code="label.userName"></spring:message>
							</form:label>
						</td>
						<td>
								<form:input path="userName"  />
								<!-- onfocus="jsMethods"(there should be a button check for user ID Availability) (Asynch) will be called and checking the existing user id in the data base and bring back the msg whether its existing or not (Synch/Asynch) -->
						</td>
					</tr>
					
					<tr>
						<td>
							<form:label path="password">
								<spring:message code="label.password"></spring:message>
							</form:label>
						</td>
						<td>
								<form:password path="password"/>
								<!-- onfocus="jsMethods"(Password strength/buss req .. -->
						</td>
					</tr>
					<tr>
						<td>
							<form:label path="confirmPassword">
								<spring:message code="label.confirmPassword"></spring:message>
							</form:label>
						</td>
						<td>
								<form:password path="confirmPassword"/>
								<!-- onfocus="jsMethods"(Password strength/buss req .. -->
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="Change Password">
						</td>
					</tr>
					

		</table>
		</fieldset>

</form:form>




</body>
</html>