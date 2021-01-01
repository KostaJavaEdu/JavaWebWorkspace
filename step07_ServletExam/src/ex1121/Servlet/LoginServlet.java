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
		//initParam가져오기
		addr = config.getInitParameter("addr");
		phone = config.getInitParameter("phone");
		
		System.out.println("addr : " + addr);
		System.out.println("phone : " + phone);
		
		//ContextParam가져오기
		ServletContext application = config.getServletContext();
		message = application.getInitParameter("message");
		fileName = application.getInitParameter("fileName");
		
		System.out.println("message : " + message);
		System.out.println("fileName : " + fileName);
	}

//	@Override
//	protected void doGet(HttpServletrequestuest request, HttpServletresponseonse response) throws ServletException, IOException {
//		System.out.println("get요청");
//	}
//
//	@Override
//	protected void doPost(HttpServletrequestuest request, HttpServletresponseonse response) throws ServletException, IOException {
//		System.out.println("post요청");
//	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("service호출됨...");
		response.setContentType("text/html;charset=UTF-8");
		//넘어오는 3개의 값을 받아서 브라우저에 출력
		
		//post방식인 결우 한글인코딩 처리
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		
		PrintWriter out = response.getWriter();
//		out.println("아이디:"+userId+"<br>");
//		out.println("비번:"+userPwd+"<br>");
//		out.println("이름:"+userName);
		
		if(dbId.equals(userId) && dbPwd.equals(userPwd)) {
			//LoginOk.jsp이동
			List<String> list = new ArrayList<String>();
			list.add("사과");list.add("딸기");
			list.add("배");list.add("바나나");
			list.add("복숭아");list.add("포도");
			
			request.setAttribute("fruits", list); //이 값이 뷰쪽으로 간다.
			
			
			request.getRequestDispatcher("LoginOk.jsp").forward(request, response);
			//response.sendRedirect("LoginOk.jsp?userName="+URLEncoder.encode(userName,"UTF-8"));
		}else {
			//LoginForm.html이동 - 메시지 출력
			out.println("<script>");
			out.println("alert('"+userName+"님 정보를 확인해주세요')");
			out.println("location.href='LoginForm.html'");
			out.println("</script>");
		}
	}//get과 post하는 일이 같아서 둘이 같이 정의해주고 싶으면 service에서 재정의 해주면 됨
	
	
	
}
