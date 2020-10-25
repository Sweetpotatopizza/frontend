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
			login.input(id, password);
			if(login.access()){
				session.setAttribute("is_login", true);
				session.setAttribute("ID", id);
				session.setAttribute("name", login.get_name());
			}
		%>
		<%=session.getAttribute("is_login") %>
		<%=session.getAttribute("ID") %>
		<%=session.getAttribute("name") %>
		<a href="logout.jsp">logout</a>
	</body>
</html>