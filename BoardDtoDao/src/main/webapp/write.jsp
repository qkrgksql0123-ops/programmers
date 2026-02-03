<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="common.css">
<style>
/* 글쓰기 컨테이너 */
.write-container {
    max-width: 600px;
    margin: 50px auto;
    background: white;
    padding: 30px;
    border-radius: 15px;
    box-shadow: 0 10px 30px rgba(0,0,0,0.1);
}

.write-container h2 {
    text-align: center;
    color: #4a90e2;
    margin-bottom: 30px;
}

/* 입력 그룹 (라벨 + 인풋) */
.input-group {
    margin-bottom: 20px;
}

.input-group label {
    display: block;
    font-weight: bold;
    margin-bottom: 8px;
    color: #555;
}

.input-group input, 
.input-group textarea {
    width: 100%;
    padding: 12px;
    border: 1px solid #ddd;
    border-radius: 8px;
    box-sizing: border-box; /* 패딩이 너비를 벗어나지 않게 함 */
    font-size: 16px;
}

.input-group input:focus, 
.input-group textarea:focus {
    outline: none;
    border-color: #4a90e2;
    box-shadow: 0 0 5px rgba(74, 144, 226, 0.3);
}

/* 내용 입력창은 좀 더 크게 */
.input-group textarea {
    height: 200px;
    resize: none; /* 크기 조절 비활성화 */
}

/* 전송 버튼 */
.submit-btn {
    width: 100%;
    padding: 15px;
    background-color: #4a90e2;
    color: white;
    border: none;
    border-radius: 8px;
    font-size: 18px;
    font-weight: bold;
    cursor: pointer;
    transition: background 0.3s;
}

.submit-btn:hover {
    background-color: #357abd;
}</style>
</head>
<body>
    <div class="write-container">
        <h2>✍️ 새 글 작성</h2>
        <form action="wrtie_proc.jsp">
            <div class="input-group">
                <label for="title">제목</label>
                <input id="title" name="title" placeholder="제목을 입력하세요" required>
            </div>
            
            <div class="input-group">
                <label for="id">아이디</label>
                <input id="id" name="id" placeholder="작성자 아이디" required>
            </div>
            
            <div class="input-group">
                <label for="text">내용</label>
                <textarea id="text" name="text" placeholder="내용을 자유롭게 입력하세요" required></textarea>
            </div>
            
            <input type="submit" value="등록하기" class="submit-btn">
        </form>
    </div>
</body>
</html>