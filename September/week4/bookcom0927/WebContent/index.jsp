<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 도서 관리</title>
<style>

</style>
</head>
<body>
	<%-- header.jsp를 include해서 재사용하기 --%>
	<%@ include file="/include/header.jsp"%>
	<c:if test="${empty loginUser }">
		<h1>인재도서관</h1>
		<img src="./img/injae.png"/>
	</c:if>
</body>
</html>