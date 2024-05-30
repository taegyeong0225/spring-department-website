<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><c:out value="${title}" /></title>
</head>
<body>
<%@ include file="header.jsp"%>

<div class="container mt-5">
    <h1><c:out value="${category}" /></h1>
	<%@ include file="../post/viewList.jsp"%>
</div>

</body>
</html>
