<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container mt-3">
  <h2>게시글 작성</h2>
  <form action="${root }/board/write" method='post'>
  
    <div class="mb-3 mt-3">
      <label for="userId">UserId:</label>
      <input type="text" class="form-control" id="userId" placeholder="Enter id" name="userId">
    </div>
    
    <div class="mb-3 mt-3">
      <label for="subject">Subject:</label>
      <input type="text" class="form-control" id="subject" placeholder="Enter subject" name="subject">
    </div>
    
    <div class="mb-3 mt-3">
      	<label for="content">Content:</label>
		<textarea class="form-control" rows="5" id="content" name="content"></textarea>
    </div>
    
    <button type = 'submit' class = "btn btn-primary">글쓰기</button>
    
  </form>
</div>
</body>
</html>