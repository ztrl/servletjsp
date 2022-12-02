<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="card m-2">
	<div class="card-header">writeForm.jsp</div>
	<div class="card-body">
		<form method="post" action="BoardWriteController">
			<div class="form-group">
				<label for="bTitle">title</label>
				<input type="text" class="form-control" id="bTitle" name="bTitle">
			</div>
			<div class="form-group">
				<label for="bContent">content</label>
				<textarea rows="5" cols="50" class="form-control" name="bContent"></textarea>
			</div>
			<button type="submit" class="btn btn-primary">Write</button>
		</form>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>