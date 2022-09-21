<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- DTO를 참조하기 위해서 import 처리가 필요하다. -->
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 결과</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid black;
}

th:nth-child(1) {
	width: 100px;
}
</style>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	<h1>회원 가입 결과</h1>
	<h2>등록 회원 정보</h2>
	<%-- c:if 태그를 이용해 request 영역에 book이 있다면 내용을 출력한다. --%>
	<c:if test="${!empty user }">
		<table>
			<thead>
				<tr>
					<th>항목</th>
					<th>내용</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>아이디</td>
					<td>${user.id }</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>${user.name }</td>
				</tr>
				
				<tr>
					<td>추천인</td>
					<td>${user.recId }</td>
				</tr>
			</tbody>
		</table>
	</c:if>
	<%-- c:if 태그를 이용해 request 영역에 book이 없다면 정보가 없음을 출력한다. --%>
	<c:if test="${empty user }">
		<p>등록된 회원이 없습니다.</p>
	</c:if>
	<!-- 다시 도서를 등록할 수 있는 링크를 제공한다. -->
	<a href="userregist.jsp">추가등록</a>
</body>
</html>