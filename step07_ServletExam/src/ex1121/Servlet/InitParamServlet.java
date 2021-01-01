package ex1121.Servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet{
	
	String addr, phone;
	String message, fileName;
	@Override
	public void init() throws ServletException {
		//initParam가져오기
		addr = super.getInitParameter("addr");
		phone = super.getInitParameter("phone");
		
		System.out.println("addr : " + addr);
		System.out.println("phone : " + phone);
		
		//ContextParam가져오기
		ServletContext application = super.getServletContext();
		message = application.getInitParameter("message");
		fileName = application.getInitParameter("fileName");
		
		System.out.println("message : " + message);
		System.out.println("fileName : " + fileName);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
