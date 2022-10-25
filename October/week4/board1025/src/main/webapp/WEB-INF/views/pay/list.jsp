<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<c:if test="${lists eq null}">
	<script type="text/javascript">
		alert("정상적인 URL 접근이 아닙니다.");
		location.href = "${root}/pay/list";
	</script>
</c:if>
      <div class="row justify-content-center">
        <div class="col-lg-10 col-md-10 col-sm-12">
          <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            <mark class="sky">벌금목록</mark>
          </h2>
        </div>
        <div class="col-lg-10 col-md-10 col-sm-12">
          <table class="table table-hover">
            <thead>
              <tr class="text-center">
                <th scope="col">글번호</th>
                <th scope="col">벌금자</th>
                <th scope="col">벌금일</th>
                <th scope="col">벌금액</th>
                <th scope="col">벌금사유</th>
              </tr>
            </thead>
            <tbody>
          <c:if test="${!empty lists}">
			<c:forEach var="pay" items="${lists}">
              <tr class="text-center">
                <th scope="row">${pay.pid}</th>
                <td class="text-start">
                  ${pay.userId}
                </td>
                <td>${pay.pday}</td>
                <td>${pay.pamount}</td>
                <td>${pay.pwhy}</td>
              </tr>
             </c:forEach>
           </c:if>
            </tbody>
          </table>
        </div>
      </div>
    </div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
