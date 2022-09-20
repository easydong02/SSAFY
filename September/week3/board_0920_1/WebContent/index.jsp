<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="UTF-8"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<style>
#main input[type=text], input[type=password] {
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
  width: 50%;
  margin: auto;
}


</style>
<body>

<div id='main'>
<h3>로그인</h3>
	<form action="./users" method='post'>
		<input type='hidden' name='command' value='login'>
	    <label for="fname">ID</label>
	    <input type="text" id="_id" name="userid" placeholder="Your id..">
	
	    <label for="lname">Password</label>
	    <input type="password" id="_pass" name="password" placeholder="Your Password..">
	
	    <input type="submit" value="로그인">
 	</form>
 	<a href="./users?command=bfregi">회원가입</a>
</div>
</body>
</html>