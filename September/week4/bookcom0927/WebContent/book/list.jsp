<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책목록</title>
<style>
#book-list {
	border-collapse: collapse;
	width: 100%;
}

#book-list td, #book-list th {
	border: 1px solid black;
}
</style>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	<h1>도서 목록</h1>
	<table id="book-list">
		<thead>
			<tr>
				<th>번호</th>
				<th>ISBN</th>
				<th>저자</th>
				<th>제목</th>
				<th>가격</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<%-- request 영역에 books로 등록된 자료를 반복문을 이용해 출력한다. --%>
			<c:forEach items="${books }" var="book" varStatus="vs">
				<tr>
					<td>${vs.count }</td>
					<td>${book.isbn}</td>
					<td>${book.author }</td>
					<td><a href='main?action=detail&isbn=${book.isbn}'>${book.title }</a></td>
					<td>${book.price }</td>
					<td><a href='main?action=delete&isbn=${book.isbn}'>삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>