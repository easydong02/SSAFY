<%@page import="com.ssafy.edu.board.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8") ;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성공</title>
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
</style>
</head>
<body>
<%
	List<Board> boards = null;
	Object obj= request.getAttribute("boards");
	if(obj !=null){
		boards=(List<Board>)obj;
	}
%>
<div id="main">
<h3>글목록</h3>
		<table id="_tboard">
			<col width="10%">
			<col width="26%">
			<col width="50%">
			<col width="14%">
			<col width="8%">
			<tr>
				<td>번호</td><td>아이디</td><td>제목</td><td>날짜</td>
			</tr>
			
			<%
				if(boards==null || boards.size()==0){
			%>
			<tr>
				<td colspan='5'>작성된 글이 없습니다.</td>
			</tr>
			<%
				}
			%>
			
			<%
				int cnt=0;
				for(Board board : boards){
			%>					
			<tr>
				<td><%=cnt++ %></td>
				<td><%=board.getUser_id()%></td>
				<td><a href = "./boards?command=detail&article_no=<%=board.getArticle_no()%>"><%=board.getSubject()%></a></td>
				<td><%=board.getRegister_time()%></td>
			</tr>
			<%
				}
			%>
		
		</table>
		
	<form action="./boards" method="post">
	<input type="hidden" name="command" value="write">
	</form>
	
</div>
<a href='./boards?command=bfwrite'>글쓰기</a>
</body>
</html>