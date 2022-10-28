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
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
    crossorigin="anonymous"
  />
 
</head>

<body>
<div class="container mt-3">
  <ul class="nav nav-pills">
    <li class="nav-item">
      <a class="nav-link active" href="${root}/board/list">글목록</a>
    </li>
    <li class="nav-item">
      <a class="nav-link active" href="${root}/board/write">글쓰기</a>
    </li>
     <li class="nav-item">
      <a class="nav-link active" href="${root}/board/alist">비동기 리스트</a>
    </li>
  </ul>
</div>
<div class="container mt-3">
  <h2 class="text-center text-success">목록</h2>
            <table class="table table-hover">
            <colgroup>
              <col width="120" />
              <col width="120" />
              <col width="120" />
              <col width="*" />
              <!-- <col width="*"> -->
              <col width="180" />
              <col width="130" />
            </colgroup>
            <thead>
              <tr>
                <th class="text-center">아이디</th>
                <th class="text-center">비밀번호</th>
                <th class="text-center">이름</th>
                <th class="text-center">이메일</th>
                <!-- <th class="text-center">주소</th> -->
                <th class="text-center">가입일</th>
                <th class="text-center">수정/삭제</th>
              </tr>
            </thead>
            <tbody id="userlist"></tbody>
          </table>
    
</div>

<!-- 글 정보 모달 -->
    <div
      class="modal fade"
      id="boardViewModal"
      data-bs-backdrop="static"
      data-bs-keyboard="false"
      tabindex="-1"
      aria-labelledby="staticBackdropLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title"><mark class="purple">글 정보</mark></h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <table class="table table-bordered">
              <colgroup>
                <col width="120" />
                <col width="*" />
                <col width="120" />
                <col width="*" />
              </colgroup>
              <tbody>
                <tr>
                  <th class="text-center">ID</th>
                  <td class="text-left" id="vid"></td>
                  <th class="text-center">회원명</th>
                  <td class="text-left" id="vname"></td>
                </tr>
                <tr>
                  <th class="text-center">제목</th>
                  <td class="text-left" id="vsubject" colspan="3"></td>
                </tr>
                <tr>
                  <th class="text-center">내용</th>
                  <td class="text-left" id="vcontent" colspan="3"></td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

 <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
    ></script>
<script>
      let root = "/board1028_2";

      //회원 상세 정보
      function boardView(el){
        var modal = new bootstrap.Modal(document.getElementById("boardViewModal"),{
          backdrop : true,
          keyboard : false,
        });
        let id = el.getAttribute("data-id");
        fetch(`\${root}/aboard/\${id}`)
          .then((Response)=>Response.json())
          .then((data)=>{
            document.querySelector("#vid").innerText = data.userId;
            document.querySelector("#vname").innerText= data.userName;
            document.querySelector("#vsubject").innerText = data.subject;
            document.querySelector("#vcontent").innerText= data.content;
            modal.show();
          })
        
      }
      
      // 회원 목록.
      fetch(`\${root}/aboard/list`)
        .then((response) => response.json())
        .then((data) => makeList(data));

      // 회원 목록 tbody
      function makeList(boards) {
        let tbody = ``;
        boards.forEach(function (board) {
          tbody += `
						<tr id="view_\${board.articleNo}" class="view text-center" data-id="\${board.articleNo}" ondblclick="boardView(this);">
							<td>\${board.articleNo}</td>
							<td>\${board.userId}</td>
							<td>\${board.subject}</td>
							<td>\${board.hit}</td>
						</tr>
					`;
        });
        document.querySelector("#userlist").innerHTML = tbody;
      }
    </script>
</body>
</html>