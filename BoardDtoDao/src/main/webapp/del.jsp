<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="DB.Dto" %>
<%@ page import="DB.Dao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String no = request.getParameter("no");
	Dao dao = new Dao();
	dao.del(no);
	response.sendRedirect("list.jsp");
%>
</body>
</html>