<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
</head>
<body>
	<%@ include file="../etc/header.jsp"%>
	<div class="container mt-5">
		<h1>자유게시판 </h1>
		<%@ include file="../post/viewList.jsp"%>
	</div>
</body>