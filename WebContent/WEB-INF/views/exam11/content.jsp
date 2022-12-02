<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		content.jsp
	</div>
	<div class="card-body">
		1. ${5} <br/>
		2. ${"홍길동"} <br/>
		3. ${2 + 5} <br/>
		4. ${2 > 5} <br/>
		5. ${5 mod 2} <br/>
		6. ${5 % 2} <br/>
		7. ${true && false} <br/>
		8. ${true || false} <br/>
		9. ${true and false} <br/>
		10. ${true or false} <br/>
		11. ${!false} <br/>
		12. ${not false} <br/>

		13. ${2 < 5}, ${2 lt 5} <br/>
		14. ${2 > 5}, ${2 gt 5} <br/>
		14. ${2 <= 5}, ${2 le 5}<br/>
		15. ${2 >= 5}, ${2 ge 5}<br/>

		16. ${empty null} <br/>
		17. ${empty ""} <br/>

		<h4 class="mt-3">pageContext를 이용해서 request, response, session의 getter 리턴값 얻기</h4>
		18. ${pageContext.request.contextPath} <br/>
		
		<h4 class="mt-3">request 범위 -> session 범위 -> application 범위 순으로 저장 된 이름의 값을 출력</h4>
		19. ${user.userId}, ${user.userName} <br/>
		20. ${board.bno}, ${board.btitle}, ${board.bcontent} <br/>
		21. ${info} <br/>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>