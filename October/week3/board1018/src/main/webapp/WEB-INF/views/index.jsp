<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>login</title>
</head>
<body>
<h1>
	안녕하세요 인재 게시판입니다.
</h1>
<form action="./login" method="post">
<table id="customers">
  <tr>
    <th>아이디</th>
    <td><input type="text" name="userId"> </td>
  </tr>
  
  <tr>
    <th>패서워드</th>
    <td><input type="text" name="userPwd"> </td>
  </tr>
  <tr>
    <td colspan="2"><input type="submit" value="로그인"> </td>
  </tr>
</table>
</form>
<a href='./regist'>회원가입</a>
</body>
</html>
