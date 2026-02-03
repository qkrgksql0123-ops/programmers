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
	Dto dto = dao.read(no);
%>
    <div class="write-container">
        <h2>✏️ 게시글 수정</h2>
        <form action="edit_proc.jsp">
            <input type="hidden" name="no" value="<%=no%>"> 
            
            <div class="input-group">
                <label for="title">제목</label>
                <input id="title" name="title" value="<%=dto.title%>" required>
            </div>
            
            <div class="input-group">
                <label>작성자</label>
                <input value="<%=dto.id%>" disabled style="background-color: #eee; cursor: not-allowed;">
            </div>
            
            <div class="input-group">
                <label for="text">내용</label>
                <textarea id="text" name="text" required><%=dto.text%></textarea>
            </div>
            
            <input type="submit" value="수정 완료" class="submit-btn">
        </form>
        
        <div style="text-align: center; margin-top: 15px;">
            <a href="list.jsp" style="color: #888; font-size: 14px;">취소하고 리스트로 돌아가기</a>
        </div>
    </div>
</body>
</html>