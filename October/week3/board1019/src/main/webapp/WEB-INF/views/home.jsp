<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var='root' value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<div><img src="${root}/img/ahn.jpg" width="30%"></div>
<a href="./guestlist">목록보기</a>
<a href="./bfguestwrite">방명록 쓰기</a>
<a href="${root}/logout">로그아웃</a>
</body>
</html>
