<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글 작성</title>
</head>
<body>

<%@ include file="../etc/header.jsp"%>

<div class="container mt-5">
    <h2>글 작성 ( ${category} )</h2>
    <form action="${pageContext.request.contextPath}/${category}/submitPost" method="post">
        <input type="hidden" name="category" value="${category}">
        <div class="mb-3">
            <label for="postTitle" class="form-label">제목</label>
            <input type="text" class="form-control" id="postTitle" name="title" required>
        </div>
        <div class="mb-3">
            <label for="postWriter" class="form-label">작성자</label>
            <input type="text" class="form-control" id="postWriter" name="userId" required>
        </div>
        <div class="mb-3">
            <label for="postContent" class="form-label">내용</label>
            <textarea class="form-control" id="postContent" name="content" rows="5" required></textarea>
        </div>
        <button type="submit" class="btn btn-danger">작성하기</button>
    </form>
</div>

</body>
</html>
