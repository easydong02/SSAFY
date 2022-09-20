<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8") ;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>

<style>
#main input[type=text], input[type=password], input[type=email] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

#main input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

#main input[type=submit]:hover {
  background-color: #45a049;
}

#main > h3{
  text-align:center;
}

#main {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  width: 30%;
  margin: auto;
}


</style>
</head>
<body>
<div id="main">
<h3>회원가입</h3>
	<form action="./users" method="post">
	<input type="hidden" name="command" value="regist">
		<label>아이디</label>
		<input type="text" name="userid">
		<label>이름</label>
		<input type="text" name="username" >
		<label>비밀번호</label>
		<input type="password" name="password">
		<label>이메일</label>
		<input type="email" name="email" >
		<input type="submit" value="회원가입" >
	</form>
	<a href='index.jsp'>HOME</a>
</div>

</body>
</html>