<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import= "DB.Dao" %>
<%@page import= "DB.Dto" %>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    /* 전체 배경과 폰트 설정 */
    body {
        font-family: 'Pretendard', -apple-system, BlinkMacSystemFont, system-ui, Roboto, sans-serif;
        background-color: #f8f9fa;
        color: #333;
        margin: 0;
        padding: 40px;
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    h2 { color: #2c3e50; margin-bottom: 20px; }

    /* 테이블 스타일 */
    .board-table {
        width: 100%;
        max-width: 900px;
        border-collapse: collapse;
        background: white;
        border-radius: 12px;
        overflow: hidden;
        box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
    }

    .board-table th {
        background-color: #4a90e2;
        color: white;
        padding: 15px;
        text-align: center;
        font-weight: 600;
    }

    .board-table td {
        padding: 15px;
        border-bottom: 1px solid #eee;
        text-align: center;
    }

    /* 마우스 올렸을 때 효과 */
    .board-table tr:hover { background-color: #f1f7ff; transition: 0.3s; }

    /* 링크 스타일 */
    a { text-decoration: none; color: #4a90e2; font-weight: bold; }
    a:hover { color: #2171cd; text-decoration: underline; }

    /* 글쓰기 버튼 */
    .btn-write {
        display: inline-block;
        margin-top: 20px;
        padding: 10px 25px;
        background-color: #4a90e2;
        color: white;
        border-radius: 8px;
        font-weight: bold;
        transition: transform 0.2s;
    }
    .btn-write:hover { background-color: #357abd; transform: translateY(-2px); text-decoration: none; }

    .date-text { color: #888; font-size: 0.9em; }
</style>
</head>
<body>
<h2>📋 자유 게시판</h2>

    <table class="board-table">
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
            </tr>
        </thead>
        <tbody>
            <%
            Dao dao = new Dao();
        	ArrayList<Dto> posts = dao.list();
                // 반복문 시작 부분 (네 기존 코드를 여기 대입해라)
                for(Dto p : posts) { 
            %>
            <tr>
                <td><%= p.no %></td>
                <td style="text-align: left; padding-left: 30px;">
                    <a href="read.jsp?no=<%= p.no %>"><%= p.title %></a>
                </td>
                <td><strong><%= p.id %></strong></td>
                <td class="date-text"><%= p.datetime %></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>

    <a href="write.jsp" class="btn-write">글 쓰기</a>
</body>
</html>