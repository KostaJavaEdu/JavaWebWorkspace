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
		
		//���۵Ǵ� ������ �ޱ�
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
		
		//����信�� ������� �����͸� ����
		String name = m.getParameter("name");
		String subject = m.getParameter("subject");
		String fileSystemName = m.getFilesystemName("file");//<input name="file"
		String fileOriginalName = m.getOriginalFileName("file");
		
		//÷������ �뷮
		File file = m.getFile("file");
		long fileSize = file.length();
		
		
		//���߰���
		request.setAttribute("name", name);//�信�� ${requestScope.name}
		request.setAttribute("subject", subject);
		request.setAttribute("fileSystemName", fileSystemName);
		request.setAttribute("fileOriginalName", fileOriginalName);
		request.setAttribute("fileSize", fileSize);
		request.setAttribute("saveDir", saveDir);
		
		//������ �̵��ϱ� request�� �����߱⶧���� forward�ۿ� �ȵ�
		request.getRequestDispatcher("upLoadResult.jsp").forward(request, response);
	}

}
