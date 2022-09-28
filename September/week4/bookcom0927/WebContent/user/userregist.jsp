<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 회원가입</title>
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
	<h1>SSAFY 회원가입</h1>
	<form method="post" action="${root }/main">
		<fieldset>
		<legend>회원정보</legend>
		<!-- front-controller pattern에서 요청을 구분하기 위한 parameter -->
		<input type="hidden" name="action" value="userregist">
		<label for="id">아이디</label>
		<input type="text" id="id" name="id"><br>
		<label for="name">이름</label>
		<input type="text" id="name" name="name"><br>
		<label for="psss">패스워드</label>
		<input type="password" id="pass" name="pass"><br>
		<label for="rec_id">추천인</label>
		<!-- <input type="text" id="rec_id" name="rec_id"> -->
		<select name="rec_id" id="rec_id">
            <option value="">추천인없다</option>
            <c:forEach items="${users}" var="user">
            <option value="${user.id}">${user.id}</option>
            </c:forEach>
        </select><br><br>
		
		<input type="submit" value="회원가입">
		<input type="reset" value="취소">
		</fieldset>
	</form>
</body>
</html>