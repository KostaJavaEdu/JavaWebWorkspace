
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
 * Servlet�ۼ���
 * 	1) HttpServlet��ӹ޴´�. (�ݵ�� public class �̴�)
 * 	2) �ʿ��� �޼ҵ� �������Ѵ�.
 * 
 * 	3) Servlet�� ����Ѵ�.
 * 		-web.xml����
 * 		-@annocation
 * */
public class LifeCycleServlet extends HttpServlet {
	public LifeCycleServlet() {
		System.out.println("LifeCycleServlet ������ ȣ��...");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init() ȣ���...");
	}
	
//	@Override
//	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//		System.out.println("service() ȣ���...");
//	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("doGet() ȣ���...");
		//������ ���
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:red'>Selvlet�ű��ϴ�</h1>");
		out.println("<script>");
		out.println("alert('�˶�!!!')");
		out.println("</script>");
		
		//HttpSession
		HttpSession session = request.getSession();
	
		
		//application
		ServletContext application = request.getServletContext();
		
		Cookie cookie = new Cookie("", "");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost() ȣ���...");
	}

	@Override
	public void destroy() {
		System.out.println("destroy() ȣ���...");
	}

	
		
}
