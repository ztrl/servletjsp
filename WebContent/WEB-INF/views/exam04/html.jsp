<%-- jsp comment--%>
<!-- html comment, which response take sthis data. -->

<%-- page 지시자 --%>
<%@ page contentType="text/html; charset=UTF-8" %>

<%-- include 지시자 --%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		html.jsp
	</div>
	<div class="card-body">
		<a href="/servletjsp/exam04/HtmlResponseController" class="btn btn-info btn-sm">HTML 응답 생성</a>
		<%-- <a href="#" class="btn btn-info btn-sm">링크1</a> --%>
		<!-- <a href="#" class="btn btn-info btn-sm">링크2</a> -->
	</div>
</div>

<%-- include 지시자 --%>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>