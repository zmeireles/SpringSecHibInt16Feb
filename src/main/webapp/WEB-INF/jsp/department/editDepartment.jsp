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
<jsp:include page="../menu.jsp" />
<form:form method="post" action="${action}" commandName="department">
		<fieldset><legend>${msg}</legend> 
			<table>
					<tr>
						<td>
							<form:label path="id">
								<spring:message code="label.id"></spring:message>
							</form:label>
						</td>
						<td>
								<form:input path="id"  disabled="false"/>
						</td>
					</tr>
					<tr>
						<td>
							<form:label path="name">
								<spring:message code="label.name"></spring:message>
							</form:label>
						</td>
						<td>
								<form:input path="name"  />
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