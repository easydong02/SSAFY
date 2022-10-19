<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var='root' value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>방명록 쓰기</title>
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
<div id='main'>
<h1>엉덩희 방명록</h1>
<form action='${root }/guestwrite' method='post'>
<table id="customers">
	<tr>
		<th>작성자</th>
		<td><input type='text' name= 'userId' value="${login.userId }" readonly></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><input type='text' name= 'subject'></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows='10' cols='50' name="content"></textarea></td>
	</tr>
	
	<tr>
		<td colspan='2'><input type='submit' value='방명록 작성'></td>
	</tr>
</table>

</form>
</div>
</body>
</html>