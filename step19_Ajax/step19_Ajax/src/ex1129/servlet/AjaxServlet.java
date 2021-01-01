package ex1129.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ajaxServlet")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String imgNames [] = {"spring.jpg",
						  "android.jpg",
						  "jquery.jpg",
						  "jsmasterbook.jpg",
						  "jpup_id.jpg",
						  };
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String book = request.getParameter("book");
		
		String imgName = imgNames[Integer.parseInt(book)];
		
		//book에 해당하는 이미지 정보를 찾아서 응답해주기 위해
		PrintWriter out = response.getWriter();
		out.println(imgName);
	}
}


