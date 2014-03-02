<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" media="screen" href="resources/css/style.css"/>
	<title>User</title>
</head>

<body>
	<jsp:include page="menu.jsp" />
	<c:url value="userViewList" var="searchUserUrl" />
	<c:url value="userRegistration" var="createUserUrl" />
	
	<form:form method="post">
		<h1 id="banner">User</h1>
		<hr />

		<div class="role">
			<table>
			</br>
			</br>
				<tr>
					<td ><a  href="${searchUserUrl}">View Users</a></td>
				</tr>
				<tr>
					<td ><a href="${createUserUrl}">Create User</a></td>
				</tr>
				
			</table>

		</div>
	</form:form>
</body>
</html>