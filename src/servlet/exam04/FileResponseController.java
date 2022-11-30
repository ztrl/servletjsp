package servlet.exam04;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="exam04.FileResponseController", urlPatterns="/exam04/FileResponseController")
public class FileResponseController extends HttpServlet{
	
	//클라이언트가 요청할 때 마다 실행
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = "사진1.jpg";
		String filePath = "C:/temp/photo1.jpg";
		String contentType = "image/jpeg";
		
		//http 응답에 Content-Type 헤더를 추가
		response.setContentType(contentType);
		//response.setHeader("Content-Type", contentType);
		
		//Browser의 종류 얻기
		String userAgent = request.getHeader("User-Agent");
		if (userAgent.contains("Trident") || userAgent.contains("MSIE")) {
			//IE
			fileName = URLEncoder.encode(fileName, "UTF-8");
		}
		else {
			//chrome, edge, firefox, safari
			fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}
		
		System.out.println(fileName);
		
		//http 응답에 Content-Disposition 헤더를 추가
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName+ "\"");
		
		//http 응답 본문에 파일 데이터 출력하기
		//only text
		//PrintWriter pw = response.getWriter();
		// image ok
		ServletOutputStream sos = response.getOutputStream();
		
		/*
		FileInputStream fis = new FileInputStream(filePath);
		byte[] data = new byte[1024];
		while(true) {
			int readByteNum = fis.read(data);
			if (readByteNum == -1) {
				break;
			}
			sos.write(data, 0, readByteNum);
		}
		sos.flush();
		fis.close();
		sos.close();
		*/
		
		Path path = Paths.get(filePath);
		Files.copy(path, sos);
		sos.flush();
		sos.close();
	}
	
}
