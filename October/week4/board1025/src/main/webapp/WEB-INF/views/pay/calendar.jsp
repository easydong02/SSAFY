<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<c:if test="${calendars eq null}">
	<script type="text/javascript">
		alert("정상적인 URL 접근이 아닙니다.");
		location.href = "${root}/pay/list";
	</script>
</c:if>
      <div class="row justify-content-center">
        <div class="col-lg-10 col-md-10 col-sm-12">
          <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            <mark class="sky">벌금달력</mark>
          </h2>
        </div>
        <div class="col-lg-10 col-md-10 col-sm-12">
          <table class="table table-hover">
            <thead>
              <tr class="text-center">
                <th  colspan="7">${caldays}</th>
              </tr>
              <tr class="text-center">
                <th scope="col">일</th>
                <th scope="col">월</th>
                <th scope="col">화</th>
                <th scope="col">수</th>
                <th scope="col">목</th>
                <th scope="col">금</th>
                <th scope="col">토</th>
              </tr>
            </thead>
            <tbody>
            ${calendars}
            </tbody>
          </table>
        </div>
      </div>
    </div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
