package servlet.exam05;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name="exam05.FileUploadController", urlPatterns="/exam05/FileUploadController")
@MultipartConfig(maxFileSize=1024 * 1024 * 10, maxRequestSize=1024 * 1024 * 50)
public class FileUploadController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//문자 파트 정보 얻기
		String title = request.getParameter("title");
		String desc = request.getParameter("desc");
		
		System.out.println("title: " + title);
		System.out.println("desc: " + desc);
		
		//1개 파일 파트 정보 얻기
		/*Part attachPart = request.getPart("attach");
		if (!attachPart.getSubmittedFileName().equals("") {
			String fileName = attachPart.getSubmittedFileName();
			long fileSize = attachPart.getSize();
			String contentType = attachPart.getContentType();
			
			System.out.println("fileName: " + fileName);
			System.out.println("fileSize: " + fileSize);
			System.out.println("contentType: " + contentType);
		}
		*/
		
		
		
		//2개 이상의 파일 파트 정보 얻기
		Collection<Part> parts = request.getParts();
		for (Part part: parts) {
			System.out.println(part.getSubmittedFileName());
			if (part.getSubmittedFileName() != null && !part.getSubmittedFileName().equals("")) {
				//DB에 저장할 3가지 정보
				String fileName = part.getSubmittedFileName();
				long fileSize = part.getSize();
				String contentType = part.getContentType();
				
				System.out.println("fileName: " + fileName);
				System.out.println("fileSize: " + fileSize);
				System.out.println("contentType: " + contentType);
				
				//파일을 파일 시스템에 저장
				String savedName = new Date().getTime() + "-" + fileName;
				String filePath = "C:/temp/download/" + savedName;
				part.write(filePath);
			}
		}
		

		
		response.sendRedirect("RequestParamInfoController");
	}
}
