package ex1125.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/downList")
public class DownListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//업로드 폴더안에 있는 파일이름의 정보를 저정해서 뷰로 이동
		ServletContext application = request.getServletContext();
		String saveDir = application.getRealPath("/save");
		
		File file = new File(saveDir);
		if(file.exists()) {
			String [] fileNames = file.list();
				
			request.setAttribute("fileNames", fileNames); //${requestScope.fileNames}
		}
		request.getRequestDispatcher("downList.jsp").forward(request, response);
	}
}
