package ex1121_solution;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginPro extends HttpServlet {
	
	String id;
	String pwd;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//ServletContext application = config.getServletContext();
		id = config.getInitParameter("id");
		pwd = config.getInitParameter("pwd");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		
		HttpSession session = request.getSession();
		if(id.equals(userId) && pwd.equals(userPwd)){
			session.setAttribute("name", userName);
			session.setAttribute("id", userId);
			session.setAttribute("time", new Date().toLocaleString());
			
			//쿠키에 저장하기
			Cookie co = new Cookie("CookieId",userId);
			co.setMaxAge(60*60*24*365);
			co.setPath("/");
			response.addCookie(co);
			
			response.sendRedirect("ex1121solution/LoginOk.jsp");
					
		}else{
			PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('"+userName+"정보를 확인해주세요.')");;
				out.println("history.back()");
				out.println("</script>");
		}	
	}
}
