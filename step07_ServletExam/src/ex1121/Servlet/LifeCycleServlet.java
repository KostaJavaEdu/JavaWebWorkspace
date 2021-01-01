
package ex1121.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet작성법
 * 	1) HttpServlet상속받는다. (반드시 public class 이다)
 * 	2) 필요한 메소드 재정의한다.
 * 
 * 	3) Servlet을 등록한다.
 * 		-web.xml문서
 * 		-@annocation
 * */
public class LifeCycleServlet extends HttpServlet {
	public LifeCycleServlet() {
		System.out.println("LifeCycleServlet 생성자 호출...");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init() 호출됨...");
	}
	
//	@Override
//	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//		System.out.println("service() 호출됨...");
//	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("doGet() 호출됨...");
		//브라우저 출력
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:red'>Selvlet신기하다</h1>");
		out.println("<script>");
		out.println("alert('알람!!!')");
		out.println("</script>");
		
		//HttpSession
		HttpSession session = request.getSession();
	
		
		//application
		ServletContext application = request.getServletContext();
		
		Cookie cookie = new Cookie("", "");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost() 호출됨...");
	}

	@Override
	public void destroy() {
		System.out.println("destroy() 호출됨...");
	}

	
		
}
