<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="row justify-content-center">
	  <div class="col-lg-10 col-md-10 col-sm-12 m-3 text-end">
		<strong>${userinfo.userName}</strong> (${userinfo.userId})님 안녕하세요.
		<a href="${root}/user/logout">로그아웃</a><br />
		<a href="${root}/pay/list">벌금목록</a>
		<c:if test="${userinfo.userId eq 'admin'}">
			<a href="${root}/pay/calendar">벌금달력</a>
			<a href="${root}/pay/write">벌금작성</a><br />
		</c:if>
	  </div>
	</div>