<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.*" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
		<h4>index.jsp</h4>
		<hr/>
		
		<div class="card">
			<div class="card-header">boardList.jsp(in WebApp)</div>
			<div class="card-body">			
				<%
					List<Board> boards = new ArrayList<>();
					for (int i = 1; i <= 10; i++) {
						Board board = new Board();
						board.setBno(i);
						board.setBtitle("title" + i);
						board.setBcontent("content" + i);
						board.setBwriter("foo");
						board.setBdate(new Date());
						boards.add(board);
					}
				%>
				
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
						<%for (Board board: boards) {%>
							<tr>
								<td><%=board.getBno()%></td>
								<td><%=board.getBtitle()%></td>
								<td><%=board.getBcontent()%></td>
								<td><%=board.getBwriter()%></td>
								<td><%=board.getBdate()%></td>
							</tr>
						<%}%>
					</tbody>
				</table>
			</div>
		</div>
		
<%@ include file="/WEB-INF/views/common/footer.jsp" %>