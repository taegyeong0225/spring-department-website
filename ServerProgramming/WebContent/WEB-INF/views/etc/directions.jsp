<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                    <th>작성자</th>
                    <th>내용</th>
                    <th>작성일</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="board" items="${boardList}">
                    <tr>
                        <td>${board.userId}</td>
                        <td>${board.content}</td>
                        <td>${board.createdDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
