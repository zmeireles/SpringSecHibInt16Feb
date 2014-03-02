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

<form:form method="post" commandName="searchUser">
		<fieldset><legend>User Search </legend> 
			<table>
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
							<input type="submit" value="Search">
						</td>
					</tr>
		</table>
		</fieldset>
<center>
		<core:if test="${!empty userList}">
			<table border="1">
				<th>
					<td>User Id</td>
					<td>User Name</td>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Address</td>
					<td colspan=2 align="center">Action</td>
				</th>
				<core:forEach items="${userList}" var="user">
				<tr>
					<td>${user.userId}</td>
					<td>${user.userName}</td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.address}</td>
				<core:if test="${user.active == 1}">
					<td><a href="javascript:deactiveRecord(${user.userId})">Deactivate</a></td>
				</core:if> 	
				<core:if test="${user.active == 0}">
					<td><a href="javascript:activeRecord(${user.userId})">Activate</a></td>
				</core:if> 	
				<td><a href="resetUser?userId=${user.userId}">Reset Password</a></td>
				</tr>
				</core:forEach>
			</table>
			</core:if>
		</center>
</form:form>


<script>
function activeRecord(id){
    var f=document.form;
    f.method="post";
    f.action='activateUser?userId'+id;
    f.submit();
}

function deactiveRecord(id){
	alert(id);
    var f=document.form;
    f.method="post";
    f.action='deactivateUser?userId='+id;
    f.submit();
}

</script>
</body>
</html>