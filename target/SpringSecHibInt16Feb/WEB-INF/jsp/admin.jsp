<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<%-- <link href="<spring:url url='resources/css/style.css' />"
	rel="stylesheet" media="screen" type="text/css" />
 --%>
<link rel="stylesheet" type="text/css" media="screen"
	href="resources/css/style.css" />
<title>Admin</title>
</head>

<body>
	<jsp:include page="menu.jsp" />
	<h1 id="banner">Admin</h1>
	<hr />

	<p>Only admins can see this page</p>
	<table>
		<tr>
			<td><a href="adminService">Admin Service</a>
			</td>
		</tr>
	</table>
</body>
</html>