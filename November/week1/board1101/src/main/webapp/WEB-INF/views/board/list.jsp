<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-3">
  <ul class="nav nav-pills">
    <li class="nav-item">
      <a class="nav-link active" href="${root }/board/list">리스트</a>
    </li>
    <li class="nav-item">
      <a class="nav-link active" href="${root }/board/write">글쓰기</a>
    </li>
  </ul>
</div>

<div class="container mt-3">
  <h2>게시글</h2>
  <table class="table table-hover">
  <col width="10%">
  <col width="20%">
  <col width="40%">
  <col width="10%">
  <col width="20%">
  <col width="10%">
    <thead>
      <tr>
        <th>번호</th>
        <th>작성자</th>
        <th>제목</th>
        <th>조회수</th>
        <th>작성일</th>
        <th>삭제</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${lists}" var="board" varStatus="vs">
      <tr>
        <td>${vs.count}</td>
        <td>${board.userId}</td>
        <td><a href='${root}/board/detail/${board.articleNo}'>${board.subject}</a></td>
        <td>${board.hit}</td>
        <td>${board.registerTime}</td>
        <td>
        <form action="${root}/board/delete/${board.articleNo}" method="post">
        	<button type="submit" class="btn btn-dark">삭제</button>
        </form>
        </td>
      </tr>
     </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>