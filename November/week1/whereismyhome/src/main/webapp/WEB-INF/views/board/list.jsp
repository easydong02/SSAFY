<%@page import="com.ssafy.util.SizeConstant"%>
<%@page import="com.ssafy.board.model.dao.BoardDaoImpl"%>
<%@page import="com.ssafy.board.model.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<%
	BoardDao bdao = BoardDaoImpl.getBoardDao();
	System.out.println(bdao);
	int cnt = bdao.getCount();
	
	int pageSize = SizeConstant.SIZE_PER_LIST;
	String pageNum = request.getParameter("pgno");
	
	if(pageNum ==null) pageNum = "1";
	
	int currentPage = Integer.parseInt(pageNum);
	
	int startRow = (currentPage - 1) * pageSize + 1;
	System.out.println(cnt + " " + currentPage + " " + startRow);
	
%>

<c:if test="${articles == null}">
	<script type="text/javascript">
		alert("정상적인 URL 접근이 아닙니다.");
		location.href = "${root}/board?act=list&pgno=1&key=&word=";
	</script>
</c:if>
<div style="height : 70px"></div>
<div class="row justify-content-center">
	<div class="col-lg-8 col-md-10 col-sm-12">
		<h2 class="my-3 py-3 shadow-sm bg-light text-center">
			<mark class="sky">글목록</mark>
		</h2>
	</div>
	<div class="col-lg-8 col-md-10 col-sm-12">
		<div class="row align-self-center mb-2">
			<div class="col-md-2 text-start">
				<c:if test="${member.role eq 'admin'}">
				<button type="button" id="btn-mv-register"
					class="btn btn-outline-primary btn-sm">글쓰기</button>
				</c:if>
			</div>
			<div class="col-md-7 offset-3">
				<form class="d-flex" id="form-search" action="board">
					<input type='hidden' name ='command' value="list">
					<select class="form-select form-select-sm ms-5 me-1 w-50"
						name="key" aria-label="검색조건">
						<option value="" selected>검색조건</option>
						<option value="subject">제목</option>
						<option value="userid">작성자</option>
					</select>
					<div class="input-group input-group-sm">
						<input type="text" class="form-control" name="word"
							placeholder="검색어..." />
						<button id="btn-search" class="btn btn-dark" type="button">검색</button>
					</div>
				</form>
			</div>
		</div>
		<table class="table table-hover">
			<thead>
				<tr class="text-center">
					<th scope="col">글번호</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">조회수</th>
					<th scope="col">작성일</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="article" items='${ articles }'>
				<tr class="text-center">
					<th scope="row">${article.articleNo }</th>
					<td class="text-start"><a href="#"
						class="article-title link-dark" data-no="${article.articleNo }"
						style="text-decoration: none"> ${article.subject }</a></td>
					<td>${article.userId }</td>
					<td>${article.hit }</td>
					<td>${article.registerTime }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
<div class = "row">
	<ul class="pagination justify-content-center">
	<% if(cnt!= 0){
		
		int pageCount = cnt / pageSize + (cnt % pageSize == 0 ? 0 : 1);
		
		int pageBlock = 10;
		
		int startPage = ((currentPage -1) / pageBlock) * pageBlock + 1;
		
		int endPage = startPage + pageBlock -1 ;
		if(endPage > pageCount){
			endPage = pageCount;
			}
		System.out.println(startPage + " " + pageBlock + " " + endPage);
		
		%>
		<% if(startPage  > pageBlock) {%>
			<li class="page-item"><a class="page-link" href="#">이전</a></li>
		<%} %>
		<% for(int i= startPage; i<=endPage; i++) { %>
			<%if(i == currentPage){ %>
				<li class="page-item active"><a class="page-link" href="board?command=list&pgno=<%=startPage-pageBlock%>&key=&word=#"><%=i %></a></li>			
		<% continue; }%>		
			<li class="page-item"><a class="page-link" href="board?command=list&pgno=<%=i %>&key=&word=#"><%=i %></a></li>			
		<% } %>
		<% if(endPage  < pageCount) {%>
			<li class="page-item"><a class="page-link" href="#">다음</a></li>
		<%} %>
	<%} %>
	</ul>
</div>
	<div id= "row">
		<ul class="pagination justify-content-center">		
		</ul>
	</div> 
</div>



<form id="form-no-param" method="get" action=" ${root }/board">
	<input type="hidden" id="act" name="command" value="view"> 
	<input		type="hidden" id="pgno" name="pgno" value="${param.pgno }"> 
	<input		type="hidden" id="key" name="key" value="${param.key }"> 
	<input		type="hidden" id="word" name="word" value="${param.word }"> 
	<input		type="hidden" id="articleno" name="articleno" value="">
</form>
<script>
	let titles = document.querySelectorAll(".article-title");
	titles.forEach(function(title) {
		title.addEventListener("click", function() {		
			document.querySelector("#command").value = "${param.view}";
			document.querySelector("#pgno").value = "${param.pgno}";
			document.querySelector("#key").value = "${param.key}";
			document.querySelector("#word").value = "${param.word}";
			document.querySelector("#articleno").value = this.getAttribute("data-no");
			document.querySelector("#form-no-param").submit();
		});
	});

	document.querySelector("#btn-mv-register").addEventListener("click",
			function() {
				location.href = "${root}/board?command=mvwrite";
			});

	document.querySelector("#btn-search").addEventListener("click", function() {
		
		let form = document.querySelector("#form-search");
		form.setAttribute("action", "${root}/board");
		form.submit();
	});
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
