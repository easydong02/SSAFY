<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 도서 관리</title>
<style>
	label{
		display: inline-block;
		width: 80px;
	}
	textarea {
	width: 100%;
}
</style>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	<h1>SSAFY 도서 관리</h1>
	<form method="post" action="${root }/main">
		<fieldset>
		<legend>도서 등록</legend>
		<!-- front-controller pattern에서 요청을 구분하기 위한 parameter -->
		<input type="hidden" name="action" value="regist">
		<label for="isbn">도서번호</label>
		<input type="text" id="isbn" name="isbn"><br>
		<label for="title">도서명</label>
		<input type="text" id="_title" name="title"><br>
		<label for="author">저자</label>
		<input type="text" id="author" name="author"><br>
		<label for="price">가격</label>
		<input type="number" id="price" name="price"><br>
		<label for="desc">설명</label>
		<br>
		<textarea id="desc" name="desc"></textarea><br>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
		</fieldset>
	</form>
</body>
</html>