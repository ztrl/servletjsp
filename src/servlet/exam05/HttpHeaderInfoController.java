package servlet.exam05;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="exam05.HttpHeaderInfoController", urlPatterns="/exam05/HttpHeaderInfoController")
public class HttpHeaderInfoController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//시작 행 얻기
		String method = request.getMethod();
		System.out.println("Method: " + method);
		
		String requestURL = request.getRequestURL().toString();
		System.out.println("Request URL: " + requestURL);
		
		String requestURI = request.getRequestURI();
		System.out.println("Request URI: " + requestURI);
		
		String contextPath = request.getContextPath();
		System.out.println("Context Path: " + contextPath);
		
		String queryString = request.getQueryString();
		System.out.println("Query String: " + queryString);
		
		//Header 얻기
		String userAgent = request.getHeader("User-Agent");
		System.out.println("User-Agent: " + userAgent);
		
		//Client IP 얻기
		String remoteAddr = request.getRemoteAddr();
		System.out.println("Remote Address: " + remoteAddr);
		
		response.sendRedirect("ContentController");
	}
}