<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- User를 사용하기 위해 dto 패키지를 import 한다. --%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }"></c:set>
<style>
#title {
	text-align: center;
}

#user-info {
	text-align: right;
}
</style>
<h1 id="title">SSAFY 도서 관리</h1>
<div id="user-info">
	<%-- session에서 loginUser를 가져와서 존재 여부에 따라 로그인 폼 또는 사용자 정보를 출력한다. --%>
	<%--로그인 정보가 없을 경우는 로그인을 위한 폼을 제공한다. --%>
	<c:if test="${empty loginUser }">
		<a href="${root }/main?action=bfuregist">회원가입</a>
		<form method="post" id ="_loginform"action="${root }/main">
			<input type="hidden" name="action" value="login">
			<input type="text" name="id" id="_id" placeholder="아이디">
			<input type="password" name="pass" id="_pass"placeholder="비밀번호">
			<input type="button" onclick="login()" value="로그인">
		</form>
	</c:if>
	<%--로그인 정보가 있는 경우는 사용자 이름과 로그아웃을 위한 링크를 생성한다.--%>
	<c:if test="${!empty loginUser }">
		<div>
			${loginUser.name }님 반갑습니다. |
			<a href="${root }/main?action=bfregist">도서 등록</a> |
			<a href="${root }/main?action=list">도서 목록</a> |
			<a href="${root }/main?action=logout">로그아웃</a>
		</div>
		
	</c:if>
</div>
<hr>
<script>
	// request 영역에 msg라는 이름의 attribute가 있다면 화면에 alert으로 출력한다.
	let msg = "${msg}";
	if (msg) {
		alert(msg)
	}
	
	function login(){
		var _id = document.getElementById("_id");
		var _pass = document.getElementById("_pass");
		var _loginform = document.getElementById("_loginform");
		if(_id ==null || _id==""){
			alert("아이디를 입력하세요");
			_id.focus();
		}
		else if(_pass ==null || _pass==""){
			alert("비밀번호를 입력하세요");
			_pass.focus();
		}
				
		else{
			alert("로그인합니다.");
			_loginform.submit();
		}
	}
</script>