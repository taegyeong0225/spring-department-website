<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글 조회</title>
</head>
<body>
<%@ include file="../etc/header.jsp"%>

<div class="container mt-5">
    <div class="row">
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="3" style="background-color: var(--bs-danger-bg-subtle); text-align:center;">게시판 글 보기</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td style="width: 20%">글 제목</td>
							<td colspan="2">${ boardDataBean.title }</td>
						</tr>
						<tr>
							<td>작성자</td>
							<td colspan="2">${boardDataBean.userId}</td>
						</tr>
						<tr>
							<td>내용</td>
							<td colspan="2" style="min-height: 200px; text-align: left;">${boardDataBean.content}</td>
						</tr>
					</tbody>
				</table>
    
        <div class="card-footer text-right">
            <a href="${pageContext.request.contextPath}/${boardDataBean.category}" class="btn btn-secondary  btn-sm">목록으로</a>
            <a href="${pageContext.request.contextPath}/${boardDataBean.category}/editPost?boardId=${boardDataBean.boardId}" class="btn btn-primary btn-sm">수정</a>
            <a href="${pageContext.request.contextPath}/${boardDataBean.category}/deletePost?boardId=${boardDataBean.boardId}" class="btn btn-danger btn-sm">삭제</a>
        </div>
    </div>
</div>

</body>
</html>
