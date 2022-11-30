package servlet.exam03;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentController extends HttpServlet{
	private String encoding;
	private String viewLocation;
	
	//최초로 서블릿을 요청할 때 한번만 실행(load-on-startup 옵션이 0보다 크면 deploy될 때 한번만 실행)
	//service(), doGet(), doPost() 등에서 사용하는 데이터를 초기화
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("exam03.ContentController.init() executed");
		if (config.getInitParameter("encoding") == null) {
			encoding = "UTF-8";			
		}
		else {
			encoding = config.getInitParameter("encoding");
		}
		if (config.getInitParameter("viewLocation") == null) {
			viewLocation = "/WEB-INF/views";
		}
		else {
			viewLocation = config.getInitParameter("viewLocation");
		}
		
	}
	
	//클라이언트가 요청할 때 마다 실행
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("exam03.ContentController.doGet() executed");
		
		request.getRequestDispatcher("/WEB-INF/views/exam03/content.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("exam03.ContentController.doPost() executed");
		
		request.setCharacterEncoding(encoding);
		
		String param1 = request.getParameter("param1");
		System.out.println("param1: " + param1);
		
		request.getRequestDispatcher(viewLocation + "/exam03/content.jsp").forward(request, response);
	}
	
	//서블릿이 제거 될 때(Undeployment)
	@Override
	public void destroy() {
		System.out.println("exam03.ContentController.destory() executed");
	}
}
