<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var='root' value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>방명록 보기</title>
<style>
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<div id='main'>
<h1>엉덩희 방명록</h1>
<form action='${root }/guestupdate' method='post'>
<table id="customers">
	<tr>
		<th>작성자</th>
		<input type='hidden' name= 'articleNo' value="${book.articleNo }"/>
		<td><input type='text' name= 'userId' value="${book.userId }" readonly="readonly"></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><input type='text' name= 'subject' value="${book.subject }"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows='10' cols='50' name="content">${book.content }</textarea></td>
	</tr>
	
	<tr>
		<th>작성시간</th>
		<td><input type='text' name= 'regtime' value="${book.regtime }" readonly></td>
	</tr>
	<c:if test="${login.userId eq book.userId }">
	<tr>
		<td colspan='1'><input type='submit' value='방명록 수정'></td>
		<td><a href="${root }/guestdelete?articleNo=${book.articleNo }">방명록 삭제</a></td>
	</tr>
	</c:if>
</table>

</form>
</div>
</body>
</html>