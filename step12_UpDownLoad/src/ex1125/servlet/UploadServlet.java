package ex1125.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/UpLoad")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//전송되는 데이터 받기
//		String name = request.getParameter("name");
//		String subject = request.getParameter("subject");
//		String file = request.getParameter("file");
//		
//		System.out.println("name : " + name);
//		System.out.println("subject : " + subject);
//		System.out.println("file : " + file);
		ServletContext application = request.getServletContext();
		String saveDir=application.getRealPath("/save");
		String encoding="UTF-8";
		int maxSize = 1024*1024*100; //100M
		MultipartRequest m = 
				new MultipartRequest(request, saveDir, maxSize, encoding, 
						new DefaultFileRenamePolicy());
		
		//결과뷰에서 출력해줄 데이터를 저장
		String name = m.getParameter("name");
		String subject = m.getParameter("subject");
		String fileSystemName = m.getFilesystemName("file");//<input name="file"
		String fileOriginalName = m.getOriginalFileName("file");
		
		//첨부파일 용량
		File file = m.getFile("file");
		long fileSize = file.length();
		
		
		//스콥결정
		request.setAttribute("name", name);//뷰에서 ${requestScope.name}
		request.setAttribute("subject", subject);
		request.setAttribute("fileSystemName", fileSystemName);
		request.setAttribute("fileOriginalName", fileOriginalName);
		request.setAttribute("fileSize", fileSize);
		request.setAttribute("saveDir", saveDir);
		
		//결과뷰로 이동하기 request로 저장했기때문에 forward밖에 안됨
		request.getRequestDispatcher("upLoadResult.jsp").forward(request, response);
	}

}
