<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DB.Dto" %>
<%@ page import="DB.Dao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="common.css">
</head>
<body>
<%
	String no = request.getParameter("no");
	Dao dao = new Dao();
	Dto d = dao.read(no);
%>
    <div class="read-container">
        <div class="read-header">
            <h2><%= d.title %></h2>
            <div class="read-info">
                <span>번호: <b><%= d.no %></b></span>
                <span>작성자: <b><%= d.id %></b></span>
                <span>작성일: <b><%= d.datetime %></b></span>
            </div>
        </div>

        <div class="read-content">
            <%= d.text %>
        </div>

        <div class="read-footer">
            <a href="list.jsp" class="btn btn-list">리스트로</a>
            <a href="edit.jsp?no=<%= d.no %>" class="btn btn-edit">수정하기</a>
            <a href="del.jsp?no=<%= d.no %>" class="btn btn-del" onclick="return confirm('정말 삭제하시겠습니까?')">삭제</a>
        </div>
    </div>
</body>
</html>