<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
      <div class="row justify-content-center">
        <div class="col-lg-10 col-md-10 col-sm-12">
          <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            <mark class="sky">벌금작성</mark>
          </h2>
        </div>
        <div class="col-lg-10 col-md-10 col-sm-12">
          <form id="form-register" method="POST" action="${root}/pay/write">
            <div class="mb-3">
              <label for="payuser" class="form-label">벌금낼 사람 : </label>
              <select id="payuser" name="userId" class="form-control">
              	<option value="">벌금낼 사람을 선택하세요</option>
              	<c:forEach items="${members}" var="member" varStatus="vs">
              	   <option value="${member.userId}">${member.userId}</option>
              	</c:forEach>
              </select>
            </div>
            <div class="mb-3">
              <label for="pamount" class="form-label">벌금액수 : </label>
              <input
                type="number"
                class="form-control"
                id="pamount"
                name="pamount"
                value="1000"
                placeholder="벌금액수"
              />
            </div>
            <div class="mb-3">
              <label for="pwhy" class="form-label">벌금이유 : </label>
              <input
                type="text"
                class="form-control"
                id="pwhy"
                name="pwhy"
                placeholder="벌금이유..."
              />
            </div>
            <div class="col-auto text-center mt-3">
              <input type="submit" id="btn-register" value="벌금내기"
              class="btn btn-outline-primary mb-3"/>
            </div>
          </form>
        </div>
      </div>
    </div>
   
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
