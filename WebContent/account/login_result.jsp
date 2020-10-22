<html>
	<head>
		<title>login result</title>
	</head>
	<body>
		<jsp:useBean id="login" class="connect.Login" scope="request"/>
		<%
			request.setCharacterEncoding("utf-8");
			String id=request.getParameter("account_id");
			String password=request.getParameter("account_password");
		%>
		<%=login.access() %>
		<p>
			ID : <%=id %>
			Password : <%=password %>
		</p>
	</body>
</html>