<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
	<link rel="stylesheet" type="text/css" media="screen" href="resources/css/style.css"/>
	<title>Admin Services</title>
</head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

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
						<td><a href="adminService?message=Please see below user list">Show All</a>
						</td>
						
					</tr>
		</table>
		</fieldset>
<center>
	<p class="message">${message}</p>
		<core:if test="${empty userList}">
				<p class="message"><spring:message code="message.NoRecoredFound"></spring:message></p>		
		</core:if>

		<core:if test="${!empty userList}">
			<table border="1">
				<th>
					<td>User Id</td>
					<td>User Name</td>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Address</td>
					<td>Status</td>
				</th>
				<core:forEach items="${userList}" var="user">
				<tr>
					<td><input type="radio" name="userId" value="${user.userId}"/></td>
					<td>${user.userId}</td>
					<td>${user.userName}</td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.address}</td>
					<td>${user.active}</td>
				</tr>
				</core:forEach>

				<tr>
				<td></td>
				
					<td><a href="javascript:deactiveRecord(getCheckedRadioValue('userId'))">Deactivate</a></td>
					<td><a href="javascript:activeRecord(getCheckedRadioValue('userId'))">Activate</a></td>
					<td><a href="javascript:resetUser()">Reset Password</a></td>
				</tr>

			</table>

			</core:if>
		</center>
</form:form>


<script>
function activeRecord(id){
	var f=document.forms[0];
    f.method="post";
    f.action='activateUser?userId='+id;
    f.submit();
}

function deactiveRecord(id){
	var f=document.forms[0];
    f.method="post";
    f.action='deactivateUser?userId='+id;
    f.submit();
}

function resetUser(){
	var f=document.forms[0];
	f.action='resetUser';
	f.method="GET";
    f.submit();
}

function getCheckedRadioValue(radioGroupName) {

	var rads = document.getElementsByName(radioGroupName),
	       i;
	   for (i=0; i < rads.length; i++)
	      if (rads[i].checked)
	          return rads[i].value;
	   return null; // or undefined, or your preferred default for none checked
	}

</script>
</body>
</html>