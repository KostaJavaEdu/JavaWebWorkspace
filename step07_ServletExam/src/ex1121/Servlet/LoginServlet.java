package ex1121.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	String dbId="choi", dbPwd="1234";
	String addr, phone, message, fileName;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LoginServlet init call.....");
		//initParam��������
		addr = config.getInitParameter("addr");
		phone = config.getInitParameter("phone");
		
		System.out.println("addr : " + addr);
		System.out.println("phone : " + phone);
		
		//ContextParam��������
		ServletContext application = config.getServletContext();
		message = application.getInitParameter("message");
		fileName = application.getInitParameter("fileName");
		
		System.out.println("message : " + message);
		System.out.println("fileName : " + fileName);
	}

//	@Override
//	protected void doGet(HttpServletrequestuest request, HttpServletresponseonse response) throws ServletException, IOException {
//		System.out.println("get��û");
//	}
//
//	@Override
//	protected void doPost(HttpServletrequestuest request, HttpServletresponseonse response) throws ServletException, IOException {
//		System.out.println("post��û");
//	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("serviceȣ���...");
		response.setContentType("text/html;charset=UTF-8");
		//�Ѿ���� 3���� ���� �޾Ƽ� �������� ���
		
		//post����� ��� �ѱ����ڵ� ó��
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		
		PrintWriter out = response.getWriter();
//		out.println("���̵�:"+userId+"<br>");
//		out.println("���:"+userPwd+"<br>");
//		out.println("�̸�:"+userName);
		
		if(dbId.equals(userId) && dbPwd.equals(userPwd)) {
			//LoginOk.jsp�̵�
			List<String> list = new ArrayList<String>();
			list.add("���");list.add("����");
			list.add("��");list.add("�ٳ���");
			list.add("������");list.add("����");
			
			request.setAttribute("fruits", list); //�� ���� �������� ����.
			
			
			request.getRequestDispatcher("LoginOk.jsp").forward(request, response);
			//response.sendRedirect("LoginOk.jsp?userName="+URLEncoder.encode(userName,"UTF-8"));
		}else {
			//LoginForm.html�̵� - �޽��� ���
			out.println("<script>");
			out.println("alert('"+userName+"�� ������ Ȯ�����ּ���')");
			out.println("location.href='LoginForm.html'");
			out.println("</script>");
		}
	}//get�� post�ϴ� ���� ���Ƽ� ���� ���� �������ְ� ������ service���� ������ ���ָ� ��
	
	
	
}
