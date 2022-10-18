<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>GuestBooks</title>
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
<h1>
	안녕하세요 인재 게시판입니다.
</h1>
<form action="./guestwrite" method = 'post'>
<table id="customers">
  <tr>
    <th>작성자</th>
    <td><input type="text" name="userId"/></td>
  </tr>
  
  <tr>
    <th>제목</th>
    <td><input type="text" name="subject"/></td>
  </tr>
  
  <tr>
    <th>내용</th>
    <td><textarea rows= "20" cols="50" name ="content"></textarea></td>
  </tr>
  
  <tr>
    <td><input type= "submit" value="글쓰기" ></td>
  </tr>
  </table>
</form>


<a href='./'>HOME</a>
</body>
</html>
