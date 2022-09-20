<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<style type="text/css">
#main {
	width: 80%;
	border: 1px solid #aabbcc;
	margin: auto;
}
#_shows {
	
}
</style>
</head>
<body>
<jsp:include page='./header.jsp'></jsp:include>
<div id="main">
<h3>상세보기</h3>
	<table id="_tboard">
	    <tr>
			<td>번호</td>
			<td><input type="text" name="article_no" readonly
			     value="${board.article_no}" width="30"></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="writer" readonly
			     value="${board.user_id}" width="30"></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="subject"  readonly
			value="${board.subject}" width="30"></td>
		</tr>
		<tr>
			<td>작성일</td>
			<td><input type="text" name="register_time"  readonly
			value="${board.register_time}" width="30"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="20" cols="50" readonly
			name="content">${board.content}</textarea></td>
		</tr>
	</table>
	<div id="_shows">
	<form action="./boards" method="post" style="display:inline">
	 <input type="hidden" name="command" value="bfupdate">
	 <input type="submit" value="글수정" >
	 <input type="hidden" name="article_no"
			     value="${board.article_no}">
	</form>
	<form action="./boards" method="post" style="display:inline">
	 <input type="hidden" name="command" value="delete">
	 <input type="submit" value="글삭제" >
	 <input type="hidden" name="article_no"
			     value="${board.article_no}">
	</form>
	</div>
</div>
<a href='index.jsp'>HOME</a>
</body>
</html>