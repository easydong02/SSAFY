<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="user-modals">
  <%
  	if(session.getAttribute("id") == null){
  		%> 
  		<jsp:include page="/WEB-INF/views/common/loginModal.jsp"></jsp:include>
  		<jsp:include page="/WEB-INF/views/common/registerModal.jsp"></jsp:include>
  		<%
  	}else{
  		%> 
  		<jsp:include page="/WEB-INF/views/common/userInfoModal.jsp"></jsp:include>
  		<%
  	}
  %>
  

  
</div>