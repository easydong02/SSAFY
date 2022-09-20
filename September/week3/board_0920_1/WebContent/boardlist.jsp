<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8") ;%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
<style type="text/css">
#main {
	width: 80%;
	border: 1px solid #aabbcc;
	margin: auto;
}
#_tboard{
   width: 80%;
   border-collapse: collapse;
   border: 1px solid black;
   margin: auto;
}

#_tboard th, #_tboard td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

#_tboard tr:hover {background-color: coral;}
h3 {
text-align: center;
}
#header {
	width: 80%;
	border: 2px solid #bbbbcc;
	margin: auto;
}
#hleft{
  float: left;
  width: 40%;
}
#hright{
  float: left;
  width: 60%;
}
</style>
</head>
<body>
<jsp:include page='./header.jsp'></jsp:include>
<div id="main">
	<h3>글목록</h3>
	<table id="_tboard">
	    <col width="10%">
	    <col width="15%">
	    <col width="40%">
	    <col width="25%">
	    <col width="10%">
		<tr>
			<td>번호</td><td>작성자</td><td>제목</td><td>작성일</td><td>삭제</td>
		</tr>
		<c:if test="${empty boards}">
			<tr>
			<td colspan="5">작성된 글이 없습니다.</td>
			</tr>
		</c:if>
		
		<c:forEach items="${boards}" var="board" varStatus="vs">
			<tr>
			<td>${vs.count}</td>
			<td>${board.user_id}</td>
			<td><a href='./boards?command=detail&article_no=${board.article_no}'>${board.subject}</a></td>
			<td>${fn:substring(board.register_time,0,10)}</td>
			<td><a href='./boards?command=delete&article_no=${board.article_no}'>삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href='./boards?command=bfwrite'>글쓰기</a>
</div>
</body>
</html>