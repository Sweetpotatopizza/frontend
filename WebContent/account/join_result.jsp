<html>
	<head>
		<title>join result</title>
	</head>
	<body>
		<jsp:useBean id="join" class="connect.Join" scope="request"/>
		<%
			request.setCharacterEncoding("utf-8");
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			String age=request.getParameter("age");
			String sex=request.getParameter("sex");
			String confirm=request.getParameter("confirm_password");
			join.input(id,name,email,password,age,sex,confirm);
			if(join.access()){
				session.setAttribute("is_login", true);
				session.setAttribute("ID",id);
				session.setAttribute("name", name);
			}
		%>
		<%=session.getAttribute("is_login") %>
		<%=session.getAttribute("ID") %>
		<%=session.getAttribute("name") %>
		<a href="logout.jsp">logout</a>
	</body>
</html>