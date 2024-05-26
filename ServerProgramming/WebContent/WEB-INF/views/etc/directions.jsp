<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>오시는 길</title>
</head>
<body>

<%@ include file="header.jsp"%>

<div class="container mt-5">
    <h1>오시는 길</h1>
    <a href="/ServerProgramming/directions/formPost?category=directions" class="btn btn-outline-secondary">글 작성</a>


    <div class="mt-4">
        <h3>게시글 목록</h3>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>작성자</th>
                    <th>제목</th>
                    <th>작성일</th>
                    <th>수정</th>
                    <th>삭제</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="board" items="${boardList}">
                    <tr>
                        <td>${board.boardId}</td>
                        <td>${board.userId}</td>
                        <td>${board.title}</td>
                        <td>${board.createdDate}</td>
                        <td><a href="${pageContext.request.contextPath}/directions/editPost?boardId=${board.boardId}" class="btn btn-primary btn-sm">수정</a></td>
                        <td><a href="${pageContext.request.contextPath}/directions/deletePost?boardId=${board.boardId}" class="btn btn-danger btn-sm">삭제</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>


</body>
</html>
