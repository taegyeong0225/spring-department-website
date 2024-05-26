<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글 수정</title>
</head>
<body>
<%@ include file="../etc/header.jsp"%>

<div class="container mt-5">
    <h2>글 수정</h2>
    <form action="${pageContext.request.contextPath}/${boardDataBean.category}/updatePost" method="post">
        <input type="hidden" name="boardId" value="${boardDataBean.boardId}">
        <input type="hidden" name="category" value="${boardDataBean.category}">
        <div class="mb-3">
            <label for="postTitle" class="form-label">제목</label>
            <input type="text" class="form-control" id="postTitle" name="title" value="${boardDataBean.title}" required>
        </div>
        <div class="mb-3">
            <label for="postContent" class="form-label">내용</label>
            <textarea class="form-control" id="postContent" name="content" rows="5" required>${boardDataBean.content}</textarea>
        </div>
        <button type="submit" class="btn btn-primary">수정하기</button>
    </form>
</div>
</body>
</html>
