<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<c:if test="${empty article}">
	<script type="text/javascript">
		alert("정상적인 URL 접근이 아닙니다.");
		location.href = "${root}/board";
	</script>
</c:if>
<div class="row justify-content-center">
	<div class="col-lg-8 col-md-10 col-sm-12">
		<h2 class="my-3 py-3 shadow-sm bg-light text-center">
			<mark class="sky">글수정</mark>
		</h2>
	</div>
	<div class="col-lg-8 col-md-10 col-sm-12">
		<form id="form-modify" method="POST" action="">
		<input type='hidden' id='command' name='command' value="">
		<input type='hidden' id='articleno' name='article_no' value='${article.articleNo }'>
			<div class="mb-3">
				<label for="subject" class="form-label">제목 : </label> 
				<input type="text" class="form-control" id="subject" name="subject"	value="${article.subject }" />
			</div>
			<div class="mb-3">
				<label for="content" class="form-label">내용 :   </label>
				<textarea class="form-control" id="content" name="content" rows="7">${article.content }</textarea>
			</div>
			<div class="col-auto text-center">
				<button type="button" id="btn-modify" class="btn btn-outline-primary mb-3">글수정</button>
				<button type="button" id="btn-list" class="btn btn-outline-danger mb-3">목록으로이동...</button>
			</div>
		</form>
	</div>
</div>

<form id="form-param" method="get" action="">
	<input type="hidden" id="ncommand" name="command" value=""> 
	<input type="hidden" id="pgno" name="pgno" value="${param.pgno }"> 
	<input type="hidden" id="key" name="key" value="${param.key }"> 
	<input type="hidden" id="word" name="word" value="${param.word }">
</form>
<script>
	document.querySelector("#btn-modify").addEventListener("click", function() {
		if (!document.querySelector("#subject").value) {
			alert("제목 입력!!");
			return;
		} else if (!document.querySelector("#content").value) {
			alert("내용 입력!!");
			return;
		} else {
			let form = document.querySelector("#form-modify");
			document.querySelector("#command").value = "modify";
			form.setAttribute("action", "${root}/board");
			form.submit();
		}
	});

	document.querySelector("#btn-list").addEventListener("click", function() {
		if (confirm("취소를 하시면 작성중인 글은 삭제됩니다.\n취소하시겠습니까?")) {
			let form = document.querySelector("#form-param");
			document.querySelector("#ncommand").value = "list";
			form.setAttribute("action", "${root}/board");
			form.submit();
		}
	});
</script>
<%@ include file="/common/footer.jsp"%>
