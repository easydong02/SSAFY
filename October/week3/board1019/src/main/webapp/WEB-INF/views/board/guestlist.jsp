<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>guest book</title>
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
<c:set var='root' value="${pageContext.request.contextPath}"></c:set>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<div id='main'>
<h1>엉덩희 방명록</h1>

<table id="customers">
  <tr>
    <th>번호</th>
    <th>작성자</th>
    <th>제목</th>
  </tr>
  <c:if test="${empty books }">
    <tr>
	    <td colspan='3'>작성된 글이 없습니다.</td>
  	</tr>
  </c:if>
  <c:forEach items='${books }' var = 'book' varStatus="vs">
  <tr>
    <td>${vs.count }</td>
    <td>${book.userId }</td>
    <td><a href="${root }/guestdetail?articleNo=${book.articleNo}">${book.subject }</a></td>
  </tr>
  </c:forEach>
</table>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>