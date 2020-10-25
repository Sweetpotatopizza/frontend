<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>logout</title>
</head>
<body>
	<%
		session.removeAttribute("is_login");
		session.removeAttribute("ID");
		session.removeAttribute("name");
	%>
	<p>logout</p>
</body>
</html>