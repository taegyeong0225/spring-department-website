<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
    .dropdown-item:active {
        background-color: var(--bs-danger-bg-subtle);
        color: white; /* 필요에 따라 글자색도 변경 */
    }
</style>
</head>
<body>
    <!-- **************************************
                   홈페이지 상단 네비게이션  
       **************************************  -->
    <nav class="navbar navbar-expand-lg" style="background-color: var(--bs-danger-bg-subtle);">
      <div class="container-fluid">
        <a class="navbar-brand" href="/ServerProgramming">인하공업전문대학 컴퓨터정보공학과</a> 
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
          <ul class="navbar-nav">
          
              <!------------ 학과안내 dropdown ---------->
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                학과안내
              </a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="/ServerProgramming/about-department">학과소개</a></li>
                <li><a class="dropdown-item" href="/ServerProgramming/department-history">학과연혁</a></li>
              </ul>
            </li>
            
            <!------------ 교과과정 dropdown ---------->
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                교과과정
              </a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="/ServerProgramming/first-grade">1학년</a></li>
                <li><a class="dropdown-item" href="/ServerProgramming/second-grade">2학년</a></li>
                <li><a class="dropdown-item" href="/ServerProgramming/third-grade">3학년</a></li>
                <li><a class="dropdown-item" href="/ServerProgramming/bachelors-degree-course">전공심화</a></li>
              </ul>
            </li>
            
            <!------------ 커뮤니티 dropdown ---------->
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                커뮤니티
              </a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="/ServerProgramming/notification">공지사항</a></li>
                <li><a class="dropdown-item" href="/ServerProgramming/frequently-asked-questions">FAQ</a></li>
                <li><a class="dropdown-item" href="/ServerProgramming/free-board">자유게시판</a></li>
              </ul>
            </li>
            
            <!------------    오시는 길     ---------->
            <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="/ServerProgramming/directions">오시는 길</a>
            </li>
            
          </ul>
        </div>
        
        <!-- ***********************
                  로그인 버튼
              *********************** -->
        <a href="#" class="btn btn-outline-danger">LOGIN</a>
      </div>
    </nav>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
