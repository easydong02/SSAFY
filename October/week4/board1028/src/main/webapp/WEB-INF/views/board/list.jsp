<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />   
<!DOCTYPE html>
<html>
<head>
<title>boardlist</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container mt-3">
  <ul class="nav nav-pills">
    <li class="nav-item">
      <a class="nav-link active" href="${root }/board/list">글목록</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${root }/board/write">글쓰기</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="${root }/board/alist">비동기목록</a>
    </li>
  </ul>
</div>


<div class="container mt-3">
  <h2 class='text-center text-success'>목록</h2>
  <table class="table table-hover">
    <thead class="table-success">
      <tr>
          <th>번호</th>
        <th>작성자</th>
        <th>제목</th>
        <th>조회수</th>
        <th>작성일</th>
      </tr>
    </thead>
    <tbody>
    <c:if test="${empty lists }">
        <tr>
            <td colspan="4">작성된 글이 없습니다</td>
        </tr>
    </c:if>
      <c:forEach items="${lists}" var="board" varStatus="vs">
          <tr>
              <td>${vs.count }</td>
              <td>${board.userId }</td>
              <td><a href="${root }/board/detail/${board.articleNo}">${board.subject }</a></td>
              <td>${board.hit }</td>
              <td>${board.registerTime }</td>
          </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>