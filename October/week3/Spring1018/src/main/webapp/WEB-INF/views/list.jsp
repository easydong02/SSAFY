<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<col width = "200px">
<col width = "500px">
<tr>
	<td>번호</td>
	<td>가수</td>
</tr>
<c:forEach items = "${lists }" var = "singer" varStatus="vs">
	<tr>
		<td>${vs.count }</td>
		<td>${singer }</td>
	</tr>
</c:forEach>
</table>
<a href='./'>HOME</a>
</body>
</html>