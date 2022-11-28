<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

		<h4>index.jsp</h4>
		<hr/>
		
		<div class="card">
			<div class="card-header">boardList.jsp(in WebINF)</div>
			<div class="card-body">			
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>내용</th>
							<th>글쓴이</th>
							<th>날짜</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="board" items="${list}">
							<tr>
								<td>${board.bno}</td>
								<td>${board.btitle}</td>
								<td>${board.bcontent}</td>
								<td>${board.bwriter}</td>
								<td>${board.bdate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
<%@ include file="/WEB-INF/views/common/footer.jsp" %>