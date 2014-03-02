
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<html>
<head>
<link rel="stylesheet" type="text/css" media="screen"
	href="resources/css/style.css" />
<title>Home</title>

</head>

<body>
	<jsp:include page="menu.jsp" />
	<h1 id="banner">Home</h1>
	<hr/>
	
	<p>Welcome <span id="username"><%=SecurityContextHolder.getContext().getAuthentication().getName()%></span>!</p>

</body>
</html>