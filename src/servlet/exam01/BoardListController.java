package servlet.exam01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;

@WebServlet(name="exam01.BoardListController", urlPatterns="/exam01/BoardListController")
public class BoardListController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardListController.service() executed");
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
		
		request.setAttribute("list", boards);
		request.getRequestDispatcher("/WEB-INF/views/exam01/boardList.jsp").forward(request, response);
	}

}