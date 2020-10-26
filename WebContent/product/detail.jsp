<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Product Detail</title>
</head>
<body>
<jsp:useBean id="detail" class="connect.Detail" scope="request"/>
<%
request.setCharacterEncoding("utf-8");
detail.access();
%>
<%=detail.get_name() %>
<%=detail.get_detail() %>
<%=detail.get_price() %>
<%=detail.get_stock() %>
<%=detail.get_major_category() %>
<%=detail.get_minor_category() %>
<%=detail.get_merchandiser() %>
<img alt="image" src="<%=detail.get_image() %>">
</body>
</html>