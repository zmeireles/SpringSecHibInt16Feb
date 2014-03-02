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

<form:form method="post" action="insertUser" commandName="user">
		<fieldset><legend>User Registration </legend> 
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
							<form:label path="firstName">
								<spring:message code="label.firstName"></spring:message>
							</form:label>
						</td>
						<td>
								<form:input path="firstName"/>
						</td>
					</tr>
					
					<tr>
						<td>
							<form:label path="lastName">
								<spring:message code="label.lastName"></spring:message>
							</form:label>
						</td>
						<td>
								<form:input path="lastName"/>
						</td>
					</tr>
					
					<tr>
						<td>
							<form:label path="address">
								<spring:message code="label.address"></spring:message>
							</form:label>
						</td>
						<td>
								<form:textarea path="address"/>
						</td>
						<!-- Google/ Yahoo API integration for City /State/Country   -->
					</tr>
					
					<tr>
						<td>
							<form:label path="contactNu">
								<spring:message code="label.contactNu"></spring:message>
							</form:label>
						</td>
						<td>
								<form:input path="contactNu"/>
						</td>
					</tr>
					
					<tr>
						<td>
							<form:label path="emailId">
								<spring:message code="label.emailId"></spring:message>
							</form:label>
						</td>
						<td>
								<form:input path="emailId"/>
						</td>
					</tr>
					
					<tr>
						<td>
							<form:label path="deptId">
								<spring:message code="label.deptId"></spring:message>
							</form:label>
						</td>
						<td>
								<form:input path="deptId"/>
						</td>
					</tr>
					
					<tr>
						<td>
							<form:label path="projId">
								<spring:message code="label.projId"></spring:message>
							</form:label>
						</td>
						<td>
								<form:input path="projId"/>
						</td>
					</tr>
					
					<tr>
						<td>
							<form:label path="locId">
								<spring:message code="label.locId"></spring:message>
							</form:label>
						</td>
						<td>
								<form:input path="locId"/>
						</td>
					</tr>
					
					<tr>
						<td>
							<form:label path="supId">
								<spring:message code="label.supId"></spring:message>
							</form:label>
						</td>
						<td>
								<form:input path="supId"/>
						</td>
					</tr>
					
					<tr>
						<td>
							<input type="submit" value="Submit">
						</td>
					</tr>
					
					
					
		</table>
		</fieldset>

</form:form>




</body>
</html>